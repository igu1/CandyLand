package me.ez.candyland.WorldGen.Generation.OreGeneration;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class GenerateOre {

    private static final List<Holder<PlacedFeature>> features = List.of(
            ModOrePlacement.ORE_CANDY
    );

    public static void onBiomeLoading(final BiomeLoadingEvent e){
        e.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION)
                .addAll(features);
    }

}