package me.ez.candyland.Datagen;

import me.ez.candyland.Main;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Main.MOD_ID)
public class DataGenerator {

    @SubscribeEvent
    public static void onGatheringData(final GatherDataEvent e){
        net.minecraft.data.DataGenerator generator = e.getGenerator();
        ExistingFileHelper helper = e.getExistingFileHelper();


        generator.addProvider(new BlockStateProvider(generator, helper));
        generator.addProvider(new ItemProvider(generator, helper));
        generator.addProvider(new LanguageProvider(generator, "en_us"));
    }
}
