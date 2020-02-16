package kmerrill285.trewrite.items.terraria.broadswords;

import kmerrill285.trewrite.items.Broadsword;
import kmerrill285.trewrite.util.Conversions;

public class OrichalcumSword extends Broadsword {

	public OrichalcumSword() {
		super();
		this.damage = 47;
		this.knockback = 5f;
		this.useTime = 23;
		this.speed = 23;
		this.sellPrice = 90;
		this.buyPrice = Conversions.sellToBuy(sellPrice);
		this.setLocation("orichalcum_broadsword");
	}

}
