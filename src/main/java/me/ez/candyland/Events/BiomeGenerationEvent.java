package me.ez.candyland.Events;

import me.ez.candyland.Main;
import me.ez.candyland.WorldGen.DecorationGeneration.ModPlacement;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class BiomeGenerationEvent {
    @SubscribeEvent
    public static void registerAttribute(BiomeLoadingEvent e){
        System.out.println("Loading Biomes");
        e.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(ModPlacement.PATCH_CANDY);
    }
}
