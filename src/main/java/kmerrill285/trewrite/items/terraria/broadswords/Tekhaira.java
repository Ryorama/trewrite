package kmerrill285.trewrite.items.terraria.broadswords;

import kmerrill285.trewrite.items.Broadsword;
import kmerrill285.trewrite.util.Conversions;

public class Tekhaira extends Broadsword {

	public Tekhaira() {
		super();
		this.damage = 57;
		this.knockback = 6.5f;
		this.useTime = 23;
		this.speed = 18;
		this.sellPrice = 90;
		this.buyPrice = Conversions.sellToBuy(sellPrice);
		this.setLocation("tekhaira");
	}

}
