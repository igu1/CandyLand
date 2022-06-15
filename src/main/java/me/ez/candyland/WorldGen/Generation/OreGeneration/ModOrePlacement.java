package me.ez.candyland.WorldGen.Generation.OreGeneration;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {

    //-----------------

    public static final Holder<PlacedFeature> ORE_CANDY =
            orePlacement("ore_candy", ModOreConfiguredFeature.ORE_CANDY);

    //-----------------


    private static Holder<PlacedFeature> orePlacement(String name, Holder<ConfiguredFeature<OreConfiguration, ?>> feature) {
        Holder<PlacedFeature> Feature = PlacementUtils.register(
                name,
                feature, commonOrePlacement(10, PlacementUtils.RANGE_10_10));
        return Feature;
    }
    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier modifier) {
        return List.of(placementModifier, InSquarePlacement.spread(), modifier, BiomeFilter.biome());
    }
    private static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(i), modifier);
    }
    private static List<PlacementModifier> rareOrePlacement(int i, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(i), p_195351_);
    }
}
