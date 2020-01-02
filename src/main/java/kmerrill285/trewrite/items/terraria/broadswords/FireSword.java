package kmerrill285.trewrite.items.terraria.broadswords;

import kmerrill285.trewrite.items.Broadsword;
import kmerrill285.trewrite.util.Conversions;

public class FireSword extends Broadsword {

	public FireSword() {
		super();
		this.damage = 35;
		this.knockback = 7f;
		this.useTime = 23;
		this.speed = 23;
		this.sellPrice = 90;
		this.buyPrice = Conversions.sellToBuy(sellPrice);
		this.setLocation("fire_sword");
	}

}
