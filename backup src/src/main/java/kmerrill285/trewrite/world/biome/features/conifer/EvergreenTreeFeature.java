package kmerrill285.trewrite.world.biome.features.conifer;

import java.awt.Color;
import java.util.Random;

import com.google.common.base.Function;
import com.mojang.datafixers.Dynamic;

import kmerrill285.trewrite.blocks.BlocksT;
import kmerrill285.trewrite.world.biome.features.LSystem.LSystem;
import kmerrill285.trewrite.world.biome.features.LSystem.LSystemPos;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class EvergreenTreeFeature extends Feature<NoFeatureConfig> {
		
	   public EvergreenTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
	      super(configFactoryIn);
	   }

	   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		   if (rand.nextInt(100) <= 3)
		   for(int i = 0; i < rand.nextInt(5) + 5; ++i) {
	         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
	         if (worldIn.getBlockState(blockpos.up()) == Blocks.AIR.getDefaultState())
	         if (worldIn.getBlockState(blockpos) == BlocksT.SNOW.getDefaultState()) {
	        	 int rad = 2;
	        	 tree(pos, worldIn, rand);
	        	 break;
	         }
	      }

	      return true;
	   }
	   
	   
	   Color[][][] stuff = new Color[80][80][80];
	   
	   public void tree(BlockPos pos, IWorld worldIn, Random r) {
		   
			Random rand = new Random(r.nextLong());
			LSystemPos lpos = new LSystemPos(32, 0, 32);
			
//			lpos.y += height;
			
//			LSystem system = new LSystem(lpos, 1, false, "place", "place", "splitrand", "place", "splitrand");
//	   	 	system.run(rand, 3);
//	   	 	LSystem stem = new LSystem(system.system.get(system.system.size() - 1).pos, 4, true, "place", "place", "splitrand");
//		 	stem.run(rand, 7); 
	   	 	
	   	 	String[] tree = {"splitrand","splitrand","place","place<75","place<50"};
	   	 	
	   	 	LSystem stem = new LSystem(lpos, 5, 3, 2.0, 1.5,tree);
		 	stem.run(rand, 10);
		 	
		 	boolean swap = rand.nextBoolean();
		 	stuff = stem.stuff;
		 	for (int x = 0; x < 80; x++) {
		 		for (int y = 0; y < 80; y++) {
		 			for (int z = 0; z < 80; z++) {
			 			if (stuff[x][y][z] == Color.BLACK) {
			 				int X = x;
			 				int Z = z;
			 				if (swap)
			 				{
			 					X = z;
			 					Z = x;
			 				}
			 				BlockPos pos2 = new BlockPos(pos.getX() + X - 32, pos.getY() + y - 2, pos.getZ() + Z - 32);
			 				if (worldIn.isAreaLoaded(pos2, 1))
			 				worldIn.setBlockState(pos2, BlocksT.LIVING_WOOD.getDefaultState(), 2);
			 			}
			 			
			 			if (stuff[x][y][z] == Color.GREEN) {
			 				int X = x;
			 				int Z = z;
			 				if (swap)
			 				{
			 					X = z;
			 					Z = x;
			 				}
			 				BlockPos pos2 = new BlockPos(pos.getX() + X - 32, pos.getY() + y - 2, pos.getZ() + Z - 32);
			 				if (worldIn.isAreaLoaded(pos2, 1)) {
			 					worldIn.setBlockState(pos2, BlocksT.LEAVES.getDefaultState(), 2);
			 					if (y + 1 < 80) {
					 				if (stuff[x][y + 1][z] == null) {
					 					if (worldIn.isAreaLoaded(pos2.up(), 1))
							 				worldIn.setBlockState(pos2, BlocksT.SNOW.getDefaultState(), 2);
					 				}
					 			}
			 				}
			 				
			 			}
			 			
		 			}
		 		}
		 	}
		}
		
		
	   
	   
	}
