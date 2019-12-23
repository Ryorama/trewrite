/*
 * Copyright (C) 2018-2019  C4
 *
 * This file is part of Curios, a mod made for Minecraft.
 *
 * Curios is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Curios is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Curios.  If not, see <https://www.gnu.org/licenses/>.
 */

package kmerrill285.trewrite.core.client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import org.lwjgl.glfw.GLFW;

import kmerrill285.trewrite.Trewrite;
import kmerrill285.trewrite.core.inventory.InventorySlot;
import kmerrill285.trewrite.core.inventory.InventoryTerraria;
import kmerrill285.trewrite.core.inventory.container.ContainerTerrariaInventory;
import kmerrill285.trewrite.core.items.ItemStackT;
import kmerrill285.trewrite.core.network.NetworkHandler;
import kmerrill285.trewrite.core.network.client.CPacketNegateFall;
import kmerrill285.trewrite.core.network.client.CPacketOpenInventoryTerraria;
import kmerrill285.trewrite.core.network.client.CPacketSyncInventoryTerraria;
import kmerrill285.trewrite.core.network.client.CPacketThrowItemTerraria;
import kmerrill285.trewrite.crafting.Recipes;
import kmerrill285.trewrite.entities.EntityItemT;
import kmerrill285.trewrite.items.ItemsT;
import kmerrill285.trewrite.items.modifiers.ItemModifier;
import kmerrill285.trewrite.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerClient {
	
	 private void scrollCallback(long handle, double xoffset, double yoffset) {
	      if (handle == Minecraft.getInstance().mainWindow.getHandle()) {
	    	  try {
				Method m = MouseHelper.class.getDeclaredMethod(Trewrite.DEBUG ? "scrollCallback" : "func_198020_a", long.class, double.class, double.class);
				m.setAccessible(true);
				try {
					m.invoke(Minecraft.getInstance().mouseHelper, handle, xoffset, yoffset);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
	    	  } catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
	      }
	      if (ContainerTerrariaInventory.inventory != null) {
	    	  if (yoffset < 0) {
		    	  if (ContainerTerrariaInventory.inventory.hotbarSelected < 9) {
		    		  ContainerTerrariaInventory.inventory.hotbarSelected++;
		    		  
		    	  }else
		    		  ContainerTerrariaInventory.inventory.hotbarSelected = 0;
		      }
		      if (yoffset > 0) {
		    	  if (ContainerTerrariaInventory.inventory.hotbarSelected > 0) {
		    		  ContainerTerrariaInventory.inventory.hotbarSelected--;
		    		  
		    	  }else
		    		  ContainerTerrariaInventory.inventory.hotbarSelected = 9;
		      }
	      }
	      
	 }
	
	 public boolean cloud = false;
	 
    @SubscribeEvent
    public void onKeyInput(TickEvent.ClientTickEvent evt) {

        if (evt.phase != TickEvent.Phase.END) return;
        
        GLFW.glfwSetScrollCallback(Minecraft.getInstance().mainWindow.getHandle(), this::scrollCallback);
        
        Minecraft mc = Minecraft.getInstance();
        
        PlayerEntity player = mc.player;
        boolean hasCloud = false;
        if (player != null) {
        	
    		InventoryTerraria inventory = ContainerTerrariaInventory.inventory;
        	if (inventory != null) {
        		for (int i = 0; i < inventory.accessory.length; i++) {
        			InventorySlot slot = inventory.accessory[i];
        			if (slot.stack != null) {
        				if (slot.stack.item == ItemsT.CLOUD_IN_A_BOTTLE) {
        					hasCloud = true;
        				}
        			}
        		}
        	}
        	
        	if (hasCloud == true) {
        		if (player.onGround == true) {
        			cloud = true;
        		}
        	} else {
        		cloud = false;
        	}
        	if (mc.gameSettings.keyBindJump.isPressed() && !player.world.getBlockState(player.getPosition().down()).getMaterial().blocksMovement()) {
        		if (cloud == true) {
        			
        			player.setMotion(player.getMotion().x, 0.5f, player.getMotion().getZ());
        			
        			Random rand = new Random();
        			for (int i = 0; i < 10; i++)
        			player.world.addParticle(ParticleTypes.CLOUD, player.posX, player.posY, player.posZ, rand.nextDouble() - 0.5f,-0.1f, rand.nextDouble() - 0.5f);
			 		NetworkHandler.INSTANCE.sendToServer(new CPacketNegateFall());
			 		
	    		    player.world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.BLOCK_SNOW_FALL, SoundCategory.PLAYERS, 1.0F, 0.4F / (rand.nextFloat() * 0.4F + 0.8F));
			 		
			 		cloud = false;
        		}
            }
        	
        	if (mc.gameSettings.keyBindJump.isKeyDown() && !player.world.getBlockState(player.getPosition().down()).getMaterial().blocksMovement()) {
        		
            }
        }
        
        
        if (KeyRegistry.openInventory.isPressed() && mc.isGameFocused()) {

        	if (mc.player != null) {
        		NetworkHandler.INSTANCE.sendToServer(new CPacketOpenInventoryTerraria(mc.player.getScoreboardName()));
        	}
        	Recipes.addAllRecipes();
        }
        if (Minecraft.getInstance() != null) {
	        if (KeyRegistry.hotbar0.isPressed()) {
	        	ContainerTerrariaInventory.inventory.hotbarSelected = 9;
	        }
	        if (KeyRegistry.hotbar1.isPressed()) {
	        	ContainerTerrariaInventory.inventory.hotbarSelected = 0;
	        }
	        if (KeyRegistry.hotbar2.isPressed()) {
	        	ContainerTerrariaInventory.inventory.hotbarSelected = 1;
	        }
	        if (KeyRegistry.hotbar3.isPressed()) {
	        	ContainerTerrariaInventory.inventory.hotbarSelected = 2;
	        }
	        if (KeyRegistry.hotbar4.isPressed()) {
	        	ContainerTerrariaInventory.inventory.hotbarSelected = 3;
	        }
	        if (KeyRegistry.hotbar5.isPressed()) {
	        	ContainerTerrariaInventory.inventory.hotbarSelected = 4;
	        }
	        if (KeyRegistry.hotbar6.isPressed()) {
	        	ContainerTerrariaInventory.inventory.hotbarSelected = 5;
	        }
	        if (KeyRegistry.hotbar7.isPressed()) {
	        	ContainerTerrariaInventory.inventory.hotbarSelected = 6;
	        }
	        if (KeyRegistry.hotbar8.isPressed()) {
	        	ContainerTerrariaInventory.inventory.hotbarSelected = 7;
	        }
	        if (KeyRegistry.hotbar9.isPressed()) {
	        	ContainerTerrariaInventory.inventory.hotbarSelected = 8;
	        }
        }
        if (KeyRegistry.drop.isPressed() && Util.terrariaInventory == true) {
        	InventoryTerraria inventory = ContainerTerrariaInventory.inventory;
//			EntityItemT item = (EntityItemT) EntitiesT.ITEM.spawn(mc.player.world, null, null, mc.player.getPosition().up(), SpawnReason.EVENT, false, false);
			if (inventory.hotbar[inventory.hotbarSelected].stack != null) {
//	        	item.item = inventory.hotbar[inventory.hotbarSelected].stack.item.itemName;
//				item.stack = inventory.hotbar[inventory.hotbarSelected].stack.size;
				EntityItemT.spawnItem(mc.player.world, mc.player.getPosition().up(), new ItemStackT(inventory.hotbar[inventory.hotbarSelected].stack.item, inventory.hotbar[inventory.hotbarSelected].stack.size, ItemModifier.getModifier(inventory.hotbar[inventory.hotbarSelected].stack.size)), 20 * 4);
//				item.pickupDelay = 20 * 4;
				InventorySlot selectedSlot = inventory.hotbar[inventory.hotbarSelected];
				inventory.hotbar[inventory.hotbarSelected].stack = null;
	    		NetworkHandler.INSTANCE.sendToServer(new CPacketThrowItemTerraria(0, selectedSlot.area, selectedSlot.id, selectedSlot.stack));
				NetworkHandler.INSTANCE.sendToServer(new CPacketSyncInventoryTerraria(0, inventory.hotbar[inventory.hotbarSelected].area, inventory.hotbar[inventory.hotbarSelected].id, inventory.hotbar[inventory.hotbarSelected].stack));
				
			}
        }
        if (KeyRegistry.swapHotbars.isPressed() && mc.isGameFocused()) {
        	Util.terrariaInventory = !Util.terrariaInventory;
        	if (Util.terrariaInventory == false) {
        		Util.justClosedInventory = true;
        	}
        }
    }
}
