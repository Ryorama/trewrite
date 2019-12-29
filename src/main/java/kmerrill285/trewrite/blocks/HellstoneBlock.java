package kmerrill285.trewrite.blocks;

import kmerrill285.trewrite.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class HellstoneBlock extends BlockT {


	
	public HellstoneBlock(Properties properties) {
		super(properties.lightValue(7), BlocksT.ORE_HARDNESS, 65.0f, "hellstone");
		this.pick = true;
	}

	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 5);
	}
   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
      entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 5);
   }
   
   public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
	   super.onReplaced(state, worldIn, pos, newState, isMoving);
	   if (pos.getY() <= Util.caveLevel)
	   { 
		   worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(0)));
		   new Thread(){
			   public void run() {
				   try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				   worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(8)));

			   }
		   }.start();
	   }
   }
   	

	   public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
	      worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
	   }

	   public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      return true;
	   }

	   public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
	      worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
	   }

	   public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
	      return false;
	   }

	   public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
	      return true;
	   }
	
}