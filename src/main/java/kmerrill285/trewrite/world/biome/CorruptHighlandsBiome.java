package kmerrill285.trewrite.world.biome;

import kmerrill285.trewrite.blocks.BlocksT;
import kmerrill285.trewrite.world.biome.features.TerrariaFeatures;
import kmerrill285.trewrite.world.biome.features.TerrariaOreFeatureConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class CorruptHighlandsBiome extends Biome  {
	protected CorruptHighlandsBiome() {
		super((new Biome.Builder()).surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.DEFAULT, 
				new SurfaceBuilderConfig(BlocksT.CORRUPT_GRASS.getDefaultState(), BlocksT.DIRT_BLOCK.getDefaultState(), BlocksT.EBONSTONE.getDefaultState()))).
				precipitation(Biome.RainType.RAIN).
				category(Biome.Category.EXTREME_HILLS)
				.depth(0.1F)
				.scale(0.5F)
				.temperature(0.2F)
				.downfall(0.3F)
				.waterColor(4159204)
				.waterFogColor(329011)
				.parent((String)null));
		  
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(TerrariaFeatures.CAVE, new ProbabilityConfig(0.14285715F)));//	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntitiesT.BLUE_SLIME, 12, 4, 4));
	      this.setRegistryName("trewrite:corrupt_highlands");
	      
//	        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(BOPBiomeFeatures.CHAPARRAL_FLOWERS, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(17)));
	      addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(TerrariaFeatures.TREES, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(48)));
	      addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(TerrariaFeatures.ORES, new TerrariaOreFeatureConfig(BlocksT.STONE_BLOCK.getDefaultState(), BlocksT.IRON_ORE.getDefaultState() , 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
		  addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(TerrariaFeatures.ORES, new TerrariaOreFeatureConfig(BlocksT.DIRT_BLOCK.getDefaultState(), BlocksT.IRON_ORE.getDefaultState(), 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
		  addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(TerrariaFeatures.ORES, new TerrariaOreFeatureConfig(BlocksT.GRASS_BLOCK.getDefaultState(), BlocksT.IRON_ORE.getDefaultState(), 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));

	}
	
	 /**
	    * Gets the current temperature at the given location, based off of the default for this biome, the elevation of the
	    * position, and {@linkplain #TEMPERATURE_NOISE} some random perlin noise.
	    */
	   public float getTemperature(BlockPos pos) {
	      return super.getTemperature(pos);
	   }
}
