package me.ez.candyland.WorldGen.Generation.DecorationGeneration;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModDecorationPlacement {
            //SKYPLACEMENT
    //    public static final Holder<PlacedFeature>
//            LYING_CANDIES = PlacementUtils.register("lying_candies",
//            ModConfiguredFeature.PATCH_CANDY,
//    RarityFilter.onAverageOnceEvery(2),
//            InSquarePlacement.spread(),
//    PlacementUtils.FULL_RANGE);

    public static final Holder<PlacedFeature> PATCH_CANDY =
            PlacementUtils.register(
                    "patch_candy",
                    ModDecorationConfiguredFeature.PATCH_CANDY,
                    RarityFilter.onAverageOnceEvery(100),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


}
