package kmerrill285.trewrite.blocks;

import java.util.ArrayList;
import java.util.Random;

import kmerrill285.trewrite.core.items.ItemStackT;
import kmerrill285.trewrite.entities.EntityItemT;
import kmerrill285.trewrite.items.ItemT;
import kmerrill285.trewrite.items.ItemsT;
import kmerrill285.trewrite.util.Conversions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockT extends Block implements IWaterLoggable {

	public int buy, sell;
	public float difficulty = 1;
	public boolean pick, axe, hammer;
	public boolean material;
	public boolean harvest = true;
	public boolean consumable;
	
	public int potionSickness;
	
	public int health, mana;
	
	public String tooltip = "";
	
	public String drop;
	
	public String name;
	public String shape = "";

	public BlockRenderLayer renderLayer = BlockRenderLayer.SOLID;
	
	protected ArrayList<String> allowed = new ArrayList<String>();

	public BlockT addAllowed(String... block) {
		for (String b : block)
				this.allowed.add(b);
		return this;
	}
	
	public BlockT(Properties properties, float hardness, float difficulty, String drop) {
		super(properties.hardnessAndResistance(hardness * 0.03f));
		this.difficulty = difficulty;
		this.drop = drop;
//		Block b;
//		b.onBlockHarvested(worldIn, pos, state, player);
	}
	
	public static final BooleanProperty field_220119_b = BlockStateProperties.WATERLOGGED;
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(field_220119_b);
     }
	
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (newState != Blocks.AIR.getDefaultState()) return;
		if (!isMoving)
		if (!worldIn.isRemote)
			
			if (state.getBlock() instanceof BlockT) {
				if (state != null)
				if (state.getBlock() != null)
				if (ItemsT.getItemFromString(((BlockT)state.getBlock()).drop) != null) {
					ItemT drop = ItemsT.getItemFromString(((BlockT)state.getBlock()).drop);
					EntityItemT.spawnItem(worldIn, pos, new ItemStackT(drop, 1));
				}
				
				if (state.getBlock() instanceof Tree) {
					if (state.getBlock() != BlocksT.CACTUS && state.getBlock() != BlocksT.CORRUPT_CACTUS) {
						if (new Random().nextInt(5) <= 1)
						EntityItemT.spawnItem(worldIn, pos, new ItemStackT(ItemsT.ACORN, 1));
					}
				}
				
			}
	}
	public boolean canHarvestBlock(BlockState state, IBlockReader world, BlockPos pos, PlayerEntity player) {
		return true;
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		 if (this.shape.contentEquals("platform_bottom")) {
			 return Platform.BOTTOM_SHAPE;
		 }
	      return super.getShape(state, worldIn, pos, context);
	   }
	
 
	 public BlockT setShape(String shape) {
		   this.shape = shape;
		   return this;
		   
	 }
	 public BlockRenderLayer getRenderLayer() {
		   return renderLayer;
		}
	 
	 
	 public BlockState breakBlock(World worldIn, BlockPos pos, BlockState state) {
		 if (!worldIn.isRemote)
			 if (state != null)
				if (state.getBlock() instanceof BlockT) {
					if (ItemsT.getItemFromString(((BlockT)state.getBlock()).drop) != null) {
						ItemT drop = ItemsT.getItemFromString(((BlockT)state.getBlock()).drop);
						EntityItemT.spawnItem(worldIn, pos, new ItemStackT(drop, 1));
					}
				}
		 return Blocks.AIR.getDefaultState();
	 }
	
	public BlockT setConsumable() {
		this.consumable = true;
		return this;
	}
	
	public BlockT setPotionSickness(int n) {
		this.potionSickness = n;
		return this;
	}
	
	public float getMiningSpeed(ItemT item) {
		if (pick && item.pick >= difficulty) {
			return item.pick / difficulty;
		}
		
		if (axe && item.axe >= difficulty) {
			return item.axe / difficulty;
		}
		
		if (hammer && item.hammer >= difficulty) {
			return item.hammer / difficulty;
		}
		
		return -1;
	}
	
	public boolean canSupport(String name) {
	     return allowed.contains(name);
	}
	
	public BlockT setLocation(String name) {
		this.name = name;
		this.setRegistryName(new ResourceLocation("trewrite", name));
		return this;
	}
	
	public BlockT setSell(int sell) {
		this.sell = sell;
		this.buy = Conversions.sellToBuy(sell);
		return this;
	}
	
	public BlockT setBuy(int buy) {
		this.sell = Conversions.buyToSell(buy);
		this.buy = buy;
		return this;
	}
	
	public BlockT setMaterial() {
		this.material = true;
		return this;
	}
	
	public BlockT setTooltip(String tooltip) {
		this.tooltip = tooltip;
		return this;
	}

	public BlockT setRenderLayer(BlockRenderLayer layer) {
		this.renderLayer = layer;
		return this;
	}
}
