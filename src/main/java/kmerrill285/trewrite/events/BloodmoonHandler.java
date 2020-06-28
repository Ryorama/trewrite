package kmerrill285.trewrite.events;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import kmerrill285.trewrite.world.WorldStateHolder;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BloodmoonHandler {
	
	public static BloodmoonHandler INSTANCE;
	
	static Random rand = new Random();
	
	private static final ResourceLocation MOON_PHASES_TEXTURES = new ResourceLocation("trewrite:textures/environment/moon_phases.png");
	private static final ResourceLocation BLOOD_MOON_PHASES_TEXTURES = new ResourceLocation("trewrite:textures/environment/blood_moon_phases.png");
	
	public static void handleBloodmoon(World worldIn) {
		
		if (worldIn.getDayTime() == 13000)
		{
			if (rand.nextDouble() <= 0.04) {
				
				WorldStateHolder.get(worldIn).bloodmoon = true;
				worldIn.getServer().getPlayerList().sendMessage(new StringTextComponent("A bloodmoon is rising!").applyTextStyles(TextFormatting.RED, TextFormatting.BOLD));
			}
		}
		
		if (worldIn.getGameTime() == 23000) {
					
				WorldStateHolder.get(worldIn).bloodmoon = false;
					
		}	
		
		
		if (WorldStateHolder.get(worldIn).bloodmoon == true) {
			
			WorldRenderer.MOON_PHASES_TEXTURES  = BLOOD_MOON_PHASES_TEXTURES;

			
		}
	}
} 