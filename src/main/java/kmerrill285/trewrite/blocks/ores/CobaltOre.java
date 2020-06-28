package kmerrill285.trewrite.blocks.ores;

import kmerrill285.trewrite.blocks.BlockT;
import kmerrill285.trewrite.blocks.BlocksT;
import kmerrill285.trewrite.util.Conversions;
import net.minecraft.block.Block.Properties;


public class CobaltOre extends BlockT {

	public CobaltOre(Properties properties) {
		super(properties, BlocksT.ORE_HARDNESS, 20.0f, "cobalt_ore");
		this.pick = true;
		this.setLocation("cobalt_ore");
		this.sell = 50;
		this.buy = Conversions.sellToBuy(sell);
		this.material = true;
	}

}
