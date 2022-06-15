package me.ez.candyland.Events;

import me.ez.candyland.Main;
import me.ez.candyland.WorldGen.Generation.DecorationGeneration.GenerateDecoration;
import me.ez.candyland.WorldGen.Generation.OreGeneration.GenerateOre;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class BiomeGenerationEvent {
    @SubscribeEvent
    public static void registerAttribute(BiomeLoadingEvent e){
        GenerateDecoration.onBiomeLoading(e);
        GenerateOre.onBiomeLoading(e);
    }
}
