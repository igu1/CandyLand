package me.ez.candyland.WorldGen.Generation.DecorationGeneration;


import me.ez.candyland.Init.Blockinit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModDecorationConfiguredFeature {
                                 //SkyGeneration
//    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_LYING_CANDIES =
//            FeatureUtils.register("patch_lying_candies",
//                    Feature.RANDOM_PATCH,
//                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
//                            new SimpleBlockConfiguration(BlockStateProvider.simple(Blockinit.LYING_CANDIES.get()))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CANDY =
            FeatureUtils.register(
                    "patch_lying_candy",
                    Feature.RANDOM_PATCH,
                    FeatureUtils.simplePatchConfiguration(
                            Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(
                                    BlockStateProvider.simple(
                                            Blockinit.LYING_CANDIES.get())), List.of(Blocks.GRASS_BLOCK)));

}
