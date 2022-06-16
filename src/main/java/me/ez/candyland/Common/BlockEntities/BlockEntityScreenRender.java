package me.ez.candyland.Common.BlockEntities;

import me.ez.candyland.Common.Block.ClientBlockRenderingEvent;
import me.ez.candyland.Common.BlockEntities.CandyMobExtractor.CandyMobExtractorScreen;
import me.ez.candyland.Common.Fluids.FluidRenderLayer;
import me.ez.candyland.Init.ContainerInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class BlockEntityScreenRender {

    public static void screenRender(FMLClientSetupEvent e){
        MenuScreens.register(ContainerInit.CANDY_EXTRACTOR.get(), CandyMobExtractorScreen::new);
    }

}
