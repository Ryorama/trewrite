package kmerrill285.trewrite.world.biome.features;

import java.util.Random;

import com.google.common.base.Function;
import com.mojang.datafixers.Dynamic;

import kmerrill285.trewrite.blocks.BlocksT;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class LifeCrystalFeature extends Feature<NoFeatureConfig> {
	
	   public LifeCrystalFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
	      super(configFactoryIn);
	   }

	   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
	      for(int i = 0; i < 10; ++i) {
	         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
	         if (worldIn.isAirBlock(blockpos)) {
	            if (worldIn.getBlockState(new BlockPos(blockpos.getX(), blockpos.getY() - 1, blockpos.getZ())).getBlock() == BlocksT.STONE_BLOCK||
	            		worldIn.getBlockState(new BlockPos(blockpos.getX(), blockpos.getY() - 1, blockpos.getZ())).getBlock() == Blocks.STONE) {
	            	if (rand.nextInt(100) == 0) {
	            		worldIn.setBlockState(blockpos, BlocksT.LIFE_CRYSTAL.getDefaultState(), 0);
	            	}
	            }
	         }
	      }

	      return true;
	   }
	}
