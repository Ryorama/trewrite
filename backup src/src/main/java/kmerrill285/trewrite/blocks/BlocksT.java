package kmerrill285.trewrite.blocks;

import kmerrill285.trewrite.blocks.CrossedBlock.Shape;
import kmerrill285.trewrite.blocks.ores.CopperOre;
import kmerrill285.trewrite.blocks.ores.DemoniteOre;
import kmerrill285.trewrite.blocks.ores.GoldOre;
import kmerrill285.trewrite.blocks.ores.IronOre;
import kmerrill285.trewrite.blocks.ores.SilverOre;
import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BlocksT {
	
	public static BlockT DIRT_BLOCK;
	public static BlockT IRON_ORE;
	public static BasicBlock STONE_BLOCK;
	public static BasicPlant MUSHROOM;
	public static BlockT GOLD_ORE;
	public static BlockT COPPER_ORE;
	public static BlockT SILVER_ORE;
	public static CrossedBlock LIFE_CRYSTAL;
	public static BlockT GRASS_BLOCK;
	public static BlockT GRASS_PATH;
	public static BlockT FURNACE;
	public static BlockT FLOWER;
	public static Torch TORCH;
	public static Torch TORCH_WALL;
	public static Torch BLUE_TORCH;
	public static Torch BLUE_TORCH_WALL;
	public static Torch ICE_TORCH;
	public static Torch ICE_TORCH_WALL;
	public static Torch ORANGE_TORCH;
	public static Torch ORANGE_TORCH_WALL;
	public static Torch PINK_TORCH;
	public static Torch PINK_TORCH_WALL;
	public static Torch RED_TORCH;
	public static Torch RED_TORCH_WALL;
	public static Torch ULTRABRIGHT_TORCH;
	public static Torch ULTRABRIGHT_TORCH_WALL;
	public static Torch WHITE_TORCH;
	public static Torch WHITE_TORCH_WALL;
	public static Torch YELLOW_TORCH;
	public static Torch YELLOW_TORCH_WALL;
	public static Torch GREEN_TORCH;
	public static Torch GREEN_TORCH_WALL;
	public static Torch PURPLE_TORCH;
	public static Torch PURPLE_TORCH_WALL;
	public static Torch CURSED_TORCH;
	public static Torch CURSED_TORCH_WALL;
	public static Torch ICHOR_TORCH;
	public static Torch ICHOR_TORCH_WALL;
	public static Torch CORRUPT_TORCH;
	public static Torch CORRUPT_TORCH_WALL;
	public static Torch RAINBOW_TORCH;
	public static Torch RAINBOW_TORCH_WALL;
	public static Torch BONE_TORCH;
	public static Torch BONE_TORCH_WALL;
	public static Tree FOREST_TREE;
	public static Tree CORRUPT_TREE;
	public static Tree CRIMSON_TREE;
	public static Tree BOREAL_TREE;
	public static Tree JUNGLE_TREE;
	public static Tree HALLOWED_TREE;
	public static Tree PALM_TREE;
	public static Door DOOR;
	public static CrossedBlock BOTTLE;
	public static BlockT TABLE;
	public static BlockT CHAIR;
	public static BlockT IRON_ANVIL;
	public static BlockT WORKBENCH;
	public static BlockT WOOD_PLATFORM;
	public static BlockT WOOD;
	public static Chest CHEST;
	public static DemoniteOre DEMONITE_ORE;
	public static BasicPlant CORRUPTION_PLANTS;
	public static BasicPlant VILE_MUSHROOM;
	public static BlockT CORRUPT_GRASS;
	public static BlockT EBONSTONE;
	public static BasicPlant SUNFLOWER;
	
	public static FallingBlock SAND;
	public static FallingBlock EBONSAND;
	public static BasicBlock DEMON_ALTAR;
	public static BasicBlock POT;
	public static PiggyBank PIGGY_BANK;

	public static BlockT HIGHLANDS_GRASS;
	public static BlockT BOG_GRASS;
	public static BlockT EBONWOOD;
	public static BlockT SHADEWOOD;
	public static BlockT PEARLWOOD;
	public static BlockT BOREAL_WOOD;
	public static BlockT PALM_WOOD;
	public static BlockT RICH_MAHOGANY;

	public static BlockT EBONWOOD_PLATFORM;
	public static BlockT SHADEWOOD_PLATFORM;
	public static BlockT PEARLWOOD_PLATFORM;
	public static BlockT BOREAL_WOOD_PLATFORM;
	public static BlockT PALM_WOOD_PLATFORM;
	public static BlockT RICH_MAHOGANY_PLATFORM;
	
	public static BlockT JUNGLE_GRASS;
	public static BlockT MUD;
	public static BlockT DEEP_MUD;
	
	public static BlockT ICE;
	public static BlockT PURPLE_ICE;
	public static BlockT THIN_ICE;
	public static BlockT SNOW;
	
	public static BlockT SAVANNA_GRASS;
	public static BlockT TALL_SAVANNA_GRASS;

	public static BlockT LIVING_WOOD;
	public static BlockT LEAVES;

	public static BlockT LIVING_WOOD_PLATFORM;
	
	public static BlockT CLAY_BLOCK;
	public static FallingBlock RED_SAND;
	public static BlockT PODZOL;
	public static BlockT CACTUS_BLOCK;
	public static Tree CACTUS;
	public static Tree CORRUPT_CACTUS;
	
	public static BlockT TALL_GRASS;
	public static Tree LARGE_MUSHROOM;
	public static BasicPlant GLOWING_MUSHROOM;
	public static BlockT MUSHROOM_GRASS;
	public static BlockT MUSHROOM_BLOCK;
	public static BlockT MUSHROOM_STEM_BLOCK;

	
	public static float GROUND_HARDNESS = 10.0f, STONE_HARDNESS = 15.0f, ORE_HARDNESS = 20.0f, DUNGEON_HARDNESS = 50.0f;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
					DIRT_BLOCK = new DirtBlock(Properties.create(Material.EARTH).sound(SoundType.GROUND)).setLocation("dirt_block"),
					IRON_ORE = new IronOre(Properties.create(Material.EARTH).sound(SoundType.STONE)),
					STONE_BLOCK = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.STONE), STONE_HARDNESS, 15, true, false, false, true, "stone_block", "stone_block"),
					MUSHROOM = (BasicPlant) new BasicPlant(Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), 0, 0, true, true, true, true, "mushroom", 15, 0, "mushroom").setShape(Shape.MUSHROOM).setPotionSickness(60).setSell(250).setConsumable().setMaterial(),
					GOLD_ORE = new GoldOre(Properties.create(Material.EARTH).sound(SoundType.STONE)),
					COPPER_ORE = new CopperOre(Properties.create(Material.EARTH).sound(SoundType.STONE)),
					SILVER_ORE = new SilverOre(Properties.create(Material.EARTH).sound(SoundType.STONE)),
					LIFE_CRYSTAL = (CrossedBlock) new CrossedBlock(Properties.create(Material.EARTH).sound(SoundType.GLASS).doesNotBlockMovement().lightValue(3), STONE_HARDNESS, 15, true, false, false, true, "life_crystal", "life_crystal").setShape(Shape.BLOCK).setSell(15000).setConsumable().setMaterial().setTooltip("Permanently increases maximum life by 20"),
					GRASS_BLOCK = new GrassBlock(Properties.create(Material.EARTH).sound(SoundType.GROUND)).setLocation("grass_block").addAllowed("flower", "mushroom", "sunflower"),
					GRASS_PATH = new GrassPath(Properties.create(Material.EARTH).sound(SoundType.GROUND)).setLocation("grass_path"),
					FURNACE = new BasicDirectional(Properties.create(Material.EARTH).sound(SoundType.STONE), STONE_HARDNESS, 15, true, false, true, false, "furnace", "furnace").setFullCube(false).setRenderLayer(BlockRenderLayer.CUTOUT).setSell(60),
					FLOWER = (BasicPlant) new BasicPlant(Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), 0, 0, true, true, true, false, "flower", "no drop").setShape(Shape.MUSHROOM).addAllowed("grass_block"),
					TORCH = (Torch) new Torch("torch", "torch").setBuy(50),
					TORCH_WALL = new TorchWall("torch", "torch"),
					BLUE_TORCH = (Torch) new Torch("blue_torch", "blue_torch").setSell(40),
					BLUE_TORCH_WALL = new TorchWall("blue_torch", "blue_torch"),
					ICE_TORCH = (Torch) new Torch("ice_torch", "ice_torch").setSell(12),
					ICE_TORCH_WALL = new TorchWall("ice_torch", "ice_torch"),
					ORANGE_TORCH = (Torch) new Torch("orange_torch", "orange_torch").setSell(40),
					ORANGE_TORCH_WALL = new TorchWall("orange_torch", "orange_torch"),
					PINK_TORCH = (Torch) new Torch("pink_torch", "pink_torch").setSell(16),
					PINK_TORCH_WALL = new TorchWall("pink_torch", "pink_torch"),
					RED_TORCH = (Torch) new Torch("red_torch", "red_torch").setSell(40),
					RED_TORCH_WALL = new TorchWall("red_torch", "red_torch"),
					WHITE_TORCH = (Torch) new Torch(12, "white_torch", "white_torch").setSell(100),
					WHITE_TORCH_WALL = new TorchWall(12, "white_torch", "white_torch"),
					YELLOW_TORCH = (Torch) new Torch("yellow_torch", "yellow_torch").setSell(40),
					YELLOW_TORCH_WALL = new TorchWall("yellow_torch", "yellow_torch"),
					GREEN_TORCH = (Torch) new Torch("green_torch", "green_torch").setSell(40),
					GREEN_TORCH_WALL = new TorchWall("green_torch", "green_torch"),
					PURPLE_TORCH = (Torch) new Torch("purple_torch", "purple_torch").setSell(40),
					PURPLE_TORCH_WALL = new TorchWall("purple_torch", "purple_torch"),
					CURSED_TORCH = (Torch) new Torch("cursed_torch", "cursed_torch").setSell(60),
					CURSED_TORCH_WALL = new TorchWall("cursed_torch", "cursed_torch"),
					ICHOR_TORCH = (Torch) new Torch("ichor_torch", "ichor_torch").setSell(66),
					ICHOR_TORCH_WALL = new TorchWall("ichor_torch", "ichor_torch"),
					CORRUPT_TORCH = (Torch) new Torch("corrupt_torch", "corrupt_torch").setSell(60),
					CORRUPT_TORCH_WALL = new TorchWall("corrupt_torch", "corrupt_torch"),
					ULTRABRIGHT_TORCH = (Torch) new Torch(8, "ultrabright_torch", "ultrabright_torch").setSell(60),
					ULTRABRIGHT_TORCH_WALL = new TorchWall(8, "ultrabright_torch", "ultrabright_torch"),
					RAINBOW_TORCH = (Torch) new Torch("rainbow_torch", "rainbow_torch").setSell(60),
					RAINBOW_TORCH_WALL = new TorchWall("rainbow_torch", "rainbow_torch"),
					BONE_TORCH = (Torch) new Torch("bone_torch", "bone_torch").setSell(60),
					BONE_TORCH_WALL = new TorchWall("bone_torch", "bone_torch"),
					FOREST_TREE = (Tree) new Tree(Properties.create(Material.WOOD).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, false, true, false, false, "trees/forest_tree", "wood").addAllowed("grass_block", "trees/forest_tree", "highlands_grass"),
					CORRUPT_TREE = (Tree) new Tree(Properties.create(Material.WOOD).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, false, true, false, false, "trees/corrupt_tree", "ebonwood").addAllowed("trees/corrupt_tree", "corrupt_grass", "bog_grass"),
					CRIMSON_TREE = (Tree) new Tree(Properties.create(Material.WOOD).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, false, true, false, false, "trees/crimson_tree", "shadewood").addAllowed("trees/crimson_tree"),
					HALLOWED_TREE = (Tree) new Tree(Properties.create(Material.WOOD).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, false, true, false, false, "trees/hallowed_tree", "pearlwood").addAllowed("trees/hallowed_tree"),
					JUNGLE_TREE = (Tree) new Tree(Properties.create(Material.WOOD).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, false, true, false, false, "trees/jungle_tree", "rich_mahogany").addAllowed("trees/jungle_tree", "bog_grass", "jungle_grass"),
					BOREAL_TREE = (Tree) new Tree(Properties.create(Material.WOOD).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, false, true, false, false, "trees/boreal_tree", "boreal_wood").addAllowed("trees/boreal_tree", "snow"),
					PALM_TREE = (Tree) new Tree(Properties.create(Material.WOOD).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, false, true, false, false, "trees/palm_tree", "palm_wood").addAllowed("trees/palm_tree"),
					DOOR = (Door) new Door(GROUND_HARDNESS, 15, "door").setSell(40),
					BOTTLE = (CrossedBlock) new CrossedBlock(Properties.create(Material.EARTH).sound(SoundType.GLASS).doesNotBlockMovement(), 0, 0, true, true, false, true, "bottle", "bottle").setShape(Shape.MUSHROOM).setMaterial(),
					TABLE = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), 15, 15, true, true, true, false, "table", "table").setRenderLayer(BlockRenderLayer.CUTOUT).setSell(15),
					CHAIR = new BasicDirectional(Properties.create(Material.EARTH).sound(SoundType.WOOD), 15, 15, true, true, true, false, "chair", "chair").setFullCube(false).setRenderLayer(BlockRenderLayer.CUTOUT).setSell(10).setShape("platform_bottom"),
					IRON_ANVIL = new BasicDirectional(Properties.create(Material.EARTH).sound(SoundType.ANVIL), 15, 15, true, true, true, false, "iron_anvil", "iron_anvil").setFullCube(false).setRenderLayer(BlockRenderLayer.CUTOUT).setSell(1000),
					WORKBENCH = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), 15, 15, true, true, true, false, "workbench", "workbench").setRenderLayer(BlockRenderLayer.CUTOUT).setSell(30),
					WOOD_PLATFORM = new Platform(Properties.create(Material.EARTH).sound(SoundType.WOOD), true, "wood_platform"),
					WOOD = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), 25, 15, true, false, false, true, "wood", "wood"),
					CHEST = new Chest(Properties.create(Material.EARTH).sound(SoundType.WOOD), "chest"),
					DEMONITE_ORE = new DemoniteOre(Properties.create(Material.EARTH).sound(SoundType.STONE)),
					CORRUPTION_PLANTS = (BasicPlant) new BasicPlant(Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), 0, 0, true, true, true, false, "corruption_plants", "no drop").setShape(Shape.MUSHROOM).addAllowed("corrupt_grass"),
					VILE_MUSHROOM = (BasicPlant) new BasicPlant(Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), 0, 0, true, true, true, true, "vile_mushroom", 0, 0, "vile_mushroom").setShape(Shape.MUSHROOM).setSell(10).setMaterial().addAllowed("corrupt_grass"),
					CORRUPT_GRASS = new CorruptGrassBlock(Properties.create(Material.EARTH).sound(SoundType.GROUND)).setLocation("corrupt_grass").addAllowed("corruption_plants", "vile_mushroom"),
					EBONSTONE = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.STONE), STONE_HARDNESS, 65, true, false, false, true, "ebonstone", "ebonstone"),
					SAND = new FallingBlock(Properties.create(Material.EARTH).sound(SoundType.SAND), GROUND_HARDNESS, 15, true, false, false, true, "sand", "sand"),
					EBONSAND = new FallingBlock(Properties.create(Material.EARTH).sound(SoundType.SAND), GROUND_HARDNESS, 15, true, false, false, true, "ebonsand", "ebonsand"),
					SUNFLOWER = (BasicPlant) new BasicPlant(Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement().lightValue(4), 0, 0, true, true, true, false, "sunflower", 0, 0, "sunflower").setShape(Shape.BLOCK).setSell(40).addAllowed("grass_block"),
					DEMON_ALTAR = (BasicBlock) new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.NETHER_WART).doesNotBlockMovement().lightValue(3), 25, 80, false, false, true, false, "altar", "no drop").setRenderLayer(BlockRenderLayer.CUTOUT),
					POT = (BasicBlock) new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.GLASS).doesNotBlockMovement(), 0, 0, true, true, true, false, "pot", "no drop").setRenderLayer(BlockRenderLayer.CUTOUT),
					PIGGY_BANK = (PiggyBank) new PiggyBank(Properties.create(Material.EARTH).sound(SoundType.GLASS), "piggy_bank").setRenderLayer(BlockRenderLayer.CUTOUT),
					HIGHLANDS_GRASS = new GrassBlock(Properties.create(Material.EARTH).sound(SoundType.GROUND)).setLocation("highlands_grass").addAllowed("flower", "mushroom", "sunflower"),
					BOG_GRASS = new GrassBlock(Properties.create(Material.EARTH).sound(SoundType.GROUND)).setLocation("bog_grass").addAllowed("flower", "mushroom", "sunflower", "corruption_plants", "vile_mushroom"),
					EBONWOOD = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), 25, 15, true, false, false, true, "ebonwood", "ebonwood"),
					SHADEWOOD = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), 25, 15, true, false, false, true, "shadewood", "shadewood"),
					PEARLWOOD = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), 25, 15, true, false, false, true, "pearlwood", "pearlwood"),
					RICH_MAHOGANY = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), 25, 15, true, false, false, true, "rich_mahogany", "rich_mahogany"),
					BOREAL_WOOD = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), 25, 15, true, false, false, true, "boreal_wood", "boreal_wood"),
					PALM_WOOD = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), 25, 15, true, false, false, true, "palm_wood", "palm_wood"),
					EBONWOOD_PLATFORM = new Platform(Properties.create(Material.EARTH).sound(SoundType.WOOD), true, "ebonwood_platform"),
					SHADEWOOD_PLATFORM = new Platform(Properties.create(Material.EARTH).sound(SoundType.WOOD), true, "shadewood_platform"),
					PEARLWOOD_PLATFORM = new Platform(Properties.create(Material.EARTH).sound(SoundType.WOOD), true, "pearlwood_platform"),
					RICH_MAHOGANY_PLATFORM = new Platform(Properties.create(Material.EARTH).sound(SoundType.WOOD), true, "rich_mahogany_platform"),
					BOREAL_WOOD_PLATFORM = new Platform(Properties.create(Material.EARTH).sound(SoundType.WOOD), true, "boreal_wood_platform"),
					PALM_WOOD_PLATFORM = new Platform(Properties.create(Material.EARTH).sound(SoundType.WOOD), true, "palm_wood_platform"),
					JUNGLE_GRASS = new JungleGrassBlock(Properties.create(Material.EARTH).sound(SoundType.GROUND)).setLocation("jungle_grass").addAllowed("flower", "mushroom", "sunflower"),
					MUD = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.GROUND), BlocksT.GROUND_HARDNESS, 10.0f, true, false, false, true, "mud", "mud"),
					DEEP_MUD = new DeepMudBlock(Properties.create(Material.EARTH).sound(SoundType.GROUND)).setLocation("deep_mud"),
					ICE = new BasicBlock(Properties.create(Material.PACKED_ICE).sound(SoundType.GLASS), STONE_HARDNESS, 15, true, false, false, true, "ice", "ice"),
					PURPLE_ICE = new BasicBlock(Properties.create(Material.PACKED_ICE).sound(SoundType.GLASS), STONE_HARDNESS, 15, true, false, false, true, "purple_ice", "purple_ice"),
					THIN_ICE = new ThinIceBlock(Properties.create(Material.PACKED_ICE).sound(SoundType.GLASS)).setLocation("thin_ice").setRenderLayer(BlockRenderLayer.TRANSLUCENT),
					SNOW = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.SNOW), GROUND_HARDNESS, 15, true, false, false, true, "snow", "snow"),
					SAVANNA_GRASS = new GrassBlock(Properties.create(Material.EARTH).sound(SoundType.GROUND)).setLocation("savannah_grass").addAllowed("tall_savannah_grass"),
					TALL_SAVANNA_GRASS = (CrossedBlock) new CrossedBlock(Properties.create(Material.EARTH).sound(SoundType.PLANT).doesNotBlockMovement(), 0, 0, true, true, false, true, "tall_savannah_grass", "none").setShape(Shape.SMALL_GRASS),
					LIVING_WOOD = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, true, false, false, false, "living_wood", "wood"),
					LEAVES = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.PLANT), GROUND_HARDNESS, 15, true, false, false, false, "leaves", "leaves"),
					LIVING_WOOD_PLATFORM = new Platform(Properties.create(Material.EARTH).sound(SoundType.WOOD), true, "living_wood_platform"),
					CLAY_BLOCK = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.STONE), GROUND_HARDNESS, 15, true, false, false, false, "clay_block", "clay_block"),
					RED_SAND = new FallingBlock(Properties.create(Material.EARTH).sound(SoundType.SAND), GROUND_HARDNESS, 15, true, false, false, true, "red_sand", "red_sand"),
					PODZOL = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WET_GRASS), GROUND_HARDNESS, 15, true, false, false, false, "podzol", "dirt_block"),
					CACTUS_BLOCK = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.CLOTH), GROUND_HARDNESS, 15, true, false, false, false, "cactus_block", "cactus_block"),
					CACTUS = (Tree) new Tree(Properties.create(Material.WOOD).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, false, true, false, false, "cactus", "cactus_block").addAllowed("cactus", "sand"),
					CORRUPT_CACTUS = (Tree) new Tree(Properties.create(Material.WOOD).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, false, true, false, false, "corrupt_cactus", "cactus_block").addAllowed("corrupt_cactus", "sand"),
					TALL_GRASS = (CrossedBlock) new CrossedBlock(Properties.create(Material.EARTH).sound(SoundType.PLANT).doesNotBlockMovement(), 0, 0, true, true, false, true, "tall_grass", "none").setShape(Shape.SMALL_GRASS),
					LARGE_MUSHROOM = (Tree) new Tree(Properties.create(Material.WOOD).sound(SoundType.WOOD), ORE_HARDNESS * 3, 15, false, true, false, false, "large_mushroom", "glowing_mushroom").addAllowed("large_mushroom", "mushroom_grass"),
					GLOWING_MUSHROOM = (BasicPlant) new BasicPlant(Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), 0, 0, true, true, true, true, "glowing_mushroom", 0, 0, "glowing_mushroom").setShape(Shape.MUSHROOM).setSell(250).setMaterial(),
					MUSHROOM_GRASS = new MushroomGrassBlock(Properties.create(Material.EARTH).sound(SoundType.GROUND)).setLocation("mushroom_grass"),
					MUSHROOM_BLOCK = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), GROUND_HARDNESS, 15, true, false, false, false, "mushroom_block", "glowing_mushroom"),
					MUSHROOM_STEM_BLOCK = new BasicBlock(Properties.create(Material.EARTH).sound(SoundType.WOOD), GROUND_HARDNESS, 15, true, false, false, false, "mushroom_stem_block", "glowing_mushroom")



				);
		JUNGLE_GRASS.drop = "mud";
		MUSHROOM_GRASS.drop = "mud";
		BOG_GRASS.drop = "mud"; 
	}
	
	
}
