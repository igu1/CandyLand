package me.ez.candyland.WorldGen.Generation.OreGeneration;

import me.ez.candyland.Init.Blockinit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ModOreConfiguredFeature {
    //------------------------

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_CANDY =
            oreConfigurationOreReplace("ore_candy", Blockinit.CANDY_ORE.get());

    //-----------------------


    public static Holder<ConfiguredFeature<OreConfiguration, ?>> oreConfigurationStoneReplace(String name, Block block) {
        Holder<ConfiguredFeature<OreConfiguration, ?>> configuration = FeatureUtils.register(name,
                Feature.ORE,
                new OreConfiguration(OreFeatures.NATURAL_STONE,
                        block.defaultBlockState(),
                        10));
        return configuration;
    }
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> oreConfigurationOreReplace(String name, Block block) {
        Holder<ConfiguredFeature<OreConfiguration, ?>> configuration = FeatureUtils.register(name,
                Feature.ORE,
                new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES,
                        block.defaultBlockState(),
                        10));
        return configuration;
    }
}
