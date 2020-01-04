package kmerrill285.trewrite.items.terraria.picks;

import java.util.List;

import kmerrill285.trewrite.items.Pickaxe;
import kmerrill285.trewrite.util.Conversions;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class NightmarePickaxe extends Pickaxe {

	public NightmarePickaxe() {
		super();
		this.pick = 70;
		this.damage = 9;
		this.knockback = 3f;
		this.useTime = 20;
		this.speed = 15;
		this.sellPrice = 100;
		this.buyPrice = Conversions.sellToBuy(sellPrice);
		this.setLocation("nightmare_pickaxe");
		this.range = -1;
	}
	
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent("Bonus: -1 range"));
	}

}
