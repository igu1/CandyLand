package me.ez.candyland;

import me.ez.candyland.Common.BlockEntities.CandyMobExtractorScreen;
import me.ez.candyland.Init.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MOD_ID)
public class Main
{
    public static final String MOD_ID = "candyland";

    public Main()
    {
        Iteminit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Blockinit.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockEntityInit.BLOCKENTITY_TYPE.register(FMLJavaModLoadingContext.get().getModEventBus());
        ContainerInit.MENUTYPE_TYPE.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSetup{

        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent e){
            MenuScreens.register(ContainerInit.CANDY_EXTRACTOR.get(), CandyMobExtractorScreen::new);
            ItemBlockRenderTypes.setRenderLayer(Blockinit.BLUE_GIFT_BOX.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blockinit.RED_GIFT_BOX.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blockinit.GREEN_GIFT_BOX.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blockinit.YELLOW_GIFT_BOX.get(), RenderType.cutout());

        }
    }

}
