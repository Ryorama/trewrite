package kmerrill285.trewrite.items.terraria.broadswords;

import kmerrill285.trewrite.items.Broadsword;
import kmerrill285.trewrite.util.Conversions;

public class MithrilSword extends Broadsword {

	public MithrilSword() {
		super();
		this.damage = 44;
		this.knockback = 5f;
		this.useTime = 23;
		this.speed = 23;
		this.sellPrice = 90;
		this.buyPrice = Conversions.sellToBuy(sellPrice);
		this.setLocation("mithril_broadsword");
	}

}
