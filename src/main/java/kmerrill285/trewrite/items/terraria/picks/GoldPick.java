package kmerrill285.trewrite.items.terraria.picks;

import java.util.List;

import kmerrill285.trewrite.items.Pickaxe;
import kmerrill285.trewrite.util.Conversions;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class GoldPick extends Pickaxe {

	public GoldPick() {
		super();
		this.pick = 60;
		this.damage = 8;
		this.knockback = 4f;
		this.useTime = 12;
		this.speed = 20;
		this.sellPrice = 100;
		this.buyPrice = Conversions.sellToBuy(sellPrice);
		this.setLocation("gold_pickaxe");
		this.range = -1;
	}
	
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent("Bonus: -1 range"));
	}

}
