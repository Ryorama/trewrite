package kmerrill285.trewrite.core.network.server;

import java.util.ArrayList;
import java.util.function.Supplier;

import kmerrill285.trewrite.core.client.ClientProxy;
import kmerrill285.trewrite.core.inventory.InventoryTerraria;
import kmerrill285.trewrite.events.WorldEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;


public class SPacketSendAccessories {
	
	public String player;
	public ArrayList<ItemStack> items = new ArrayList<ItemStack>();
	public SPacketSendAccessories(String player) {
		this.player = player;
	}
	
	public void encode(PacketBuffer buf) {
		buf.writeString(player);
        InventoryTerraria inventory = WorldEvents.inventories.get(player);
        if (inventory != null) {
        	for (int i = 0; i < inventory.accessory.length; i++) {
        		if (inventory.accessoryVanity[i].stack != null) 
        		{
        			buf.writeItemStack(inventory.accessoryVanity[i].stack.itemForRender);
        		} else {
        			if (inventory.accessory[i].stack != null) {
        				buf.writeItemStack(inventory.accessory[i].stack.itemForRender);
        			}
        		}
        	}
        }
    }
	
	public SPacketSendAccessories(PacketBuffer buf) {
		player = buf.readString(100).trim();
		while (buf.isReadable()) {
			items.add(buf.readItemStack());
		}
	}
	
	public void handle(Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ClientProxy.playerAccessories.put(player, items);
        });
        ctx.get().setPacketHandled(true);
	}
}
