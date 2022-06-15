package me.ez.candyland.WorldGen.Generation.DecorationGeneration;

import me.ez.candyland.Main;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class GenerateDecoration {

    private static final List<Holder<PlacedFeature>> features = List.of(
            ModDecorationPlacement.PATCH_CANDY
    );

    @SubscribeEvent
    public static void onBiomeLoading(final BiomeLoadingEvent e){
        e.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION)
                .addAll(features);
    }

}
