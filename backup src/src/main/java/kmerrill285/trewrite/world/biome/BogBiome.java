package kmerrill285.trewrite.world.biome;

import kmerrill285.trewrite.blocks.BlocksT;
import kmerrill285.trewrite.entities.EntitiesT;
import kmerrill285.trewrite.world.biome.features.TerrariaFeatures;
import kmerrill285.trewrite.world.biome.features.TerrariaOreFeatureConfig;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class BogBiome extends Biome  {
	
	protected BogBiome() {
		super((new Biome.Builder()).surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.DEFAULT, 
				new SurfaceBuilderConfig(BlocksT.BOG_GRASS.getDefaultState(), BlocksT.MUD.getDefaultState(), BlocksT.STONE_BLOCK.getDefaultState())
				)).
				precipitation(Biome.RainType.RAIN).
				category(Biome.Category.SWAMP)
				.depth(-0.2F)
				.scale(0.1F)
				.temperature(0.8F)
				.downfall(0.9F)
				.waterColor(0x41824f)
				.waterFogColor(0x6a947d)
				.parent((String)null));
	    this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(TerrariaFeatures.CAVE, new ProbabilityConfig(0.14285715F)));
//		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntitiesT.BLUE_SLIME, 12, 4, 4));
	   this.setRegistryName("trewrite:bog");
	   addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(TerrariaFeatures.TREES, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(70)));
	   addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(TerrariaFeatures.ORES, new TerrariaOreFeatureConfig(BlocksT.STONE_BLOCK.getDefaultState(), BlocksT.IRON_ORE.getDefaultState() , 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
	   addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(TerrariaFeatures.ORES, new TerrariaOreFeatureConfig(BlocksT.DIRT_BLOCK.getDefaultState(), BlocksT.IRON_ORE.getDefaultState(), 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
	   addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(TerrariaFeatures.ORES, new TerrariaOreFeatureConfig(BlocksT.GRASS_BLOCK.getDefaultState(), BlocksT.IRON_ORE.getDefaultState(), 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
	   addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(TerrariaFeatures.ORES, new TerrariaOreFeatureConfig(BlocksT.BOG_GRASS.getDefaultState(), BlocksT.IRON_ORE.getDefaultState(), 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
	   addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(TerrariaFeatures.ORES, new TerrariaOreFeatureConfig(BlocksT.MUD.getDefaultState(), BlocksT.IRON_ORE.getDefaultState(), 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
	   addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(TerrariaFeatures.ORES, new TerrariaOreFeatureConfig(BlocksT.BOG_GRASS.getDefaultState(), BlocksT.MUD.getDefaultState(), 25), Placement.COUNT_RANGE, new CountRangeConfig(100, 0, 0, 128)));
	   addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(TerrariaFeatures.ORES, new TerrariaOreFeatureConfig(BlocksT.BOG_GRASS.getDefaultState(), BlocksT.DEEP_MUD.getDefaultState(), 50), Placement.COUNT_RANGE, new CountRangeConfig(50, 0, 0, 128)));
	}
	
	
	
	/**
	    * Gets the current temperature at the given location, based off of the default for this biome, the elevation of the
	    * position, and {@linkplain #TEMPERATURE_NOISE} some random perlin noise.
	    */
	   public float getTemperature(BlockPos pos) {
	      return super.getTemperature(pos);
	   }
}
