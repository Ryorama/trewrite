package kmerrill285.trewrite.blocks;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;

public class GrassBlock extends DirtBlock {

	public GrassBlock(Properties properties) {
		super(properties);
	}
	
	public void tick(IBlockState state, World worldIn, BlockPos pos, Random random) {
		if (!worldIn.isRemote) {
			
			if (!worldIn.isAreaLoaded(pos, 3)) return;
			BlockPos pos2 = pos.add(0, 1, 0);
			if (worldIn.isBlockPresent(pos2)) {
				if (worldIn.getBlockState(pos2).isFullCube()) {
					worldIn.setBlockState(pos, BlocksT.DIRT_BLOCK.getDefaultState());
						return;
					}
				if (worldIn.getBlockState(pos2).getBlock().getDefaultState() == Blocks.AIR.getDefaultState()) {
					if (random.nextInt(100 * 5) <= 2) {
						worldIn.setBlockState(pos2, BlocksT.FLOWER.getDefaultState().with(BasicPlant.TYPE, random.nextInt(21)));
						if (random.nextInt(15) == 0) {
							worldIn.setBlockState(pos2, BlocksT.MUSHROOM.getDefaultState());
						}
					}
				}
			}
			for (int i = 0; i < 4; ++i) {
				BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
				if (blockpos.getY() == pos.getY() - 1) {
					return;
				}
				if (!worldIn.isBlockPresent(blockpos)) return;
				if (worldIn.getBlockState(blockpos).getBlock() == BlocksT.DIRT_BLOCK) {
					worldIn.setBlockState(blockpos, this.getDefaultState());
				}
			}
		}
	}
	
	public int tickRate (IWorldReaderBase world) {
		return 0;
	}
	
	public boolean getTickRandomly(IBlockState state) {
		return true;
	}
	
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
	      return BlocksT.DIRT_BLOCK;
	}

	
//	public void tick(IBlockState state, World worldIn, BlockPos pos, Random random) {
//	      if (!worldIn.isRemote) {
//	         if (!worldIn.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
//	         if (!func_196383_a(worldIn, pos)) {
//	            worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState());
//	         } else {
//	            if (worldIn.getLight(pos.up()) >= 9) {
//	               for(int i = 0; i < 4; ++i) {
//	                  BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
//	                  if (!worldIn.isBlockPresent(blockpos)) {
//	                     return;
//	                  }
//
//	                  if (worldIn.getBlockState(blockpos).getBlock() == Blocks.DIRT && func_196384_b(worldIn, blockpos)) {
//	                     worldIn.setBlockState(blockpos, this.getDefaultState());
//	                  }
//	               }
//	            }
//
//	         }
//	      }
//	   }
}
