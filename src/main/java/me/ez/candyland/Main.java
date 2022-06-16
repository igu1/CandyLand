package me.ez.candyland;

import me.ez.candyland.Client.CandyTntEntityRenderer;
import me.ez.candyland.Common.Block.ClientBlockRenderingEvent;
import me.ez.candyland.Common.BlockEntities.BlockEntityScreenRender;
import me.ez.candyland.Common.BlockEntities.CandyMobExtractor.CandyMobExtractorScreen;
import me.ez.candyland.Common.Fluids.FluidRenderLayer;
import me.ez.candyland.Events.AttributeEvents;
import me.ez.candyland.Init.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
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
        Iteminit.CANDIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        Iteminit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Blockinit.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MiscEntityInit.ENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockEntityInit.BLOCKENTITY_TYPE.register(FMLJavaModLoadingContext.get().getModEventBus());
        AttributeInit.ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ContainerInit.MENUTYPE_TYPE.register(FMLJavaModLoadingContext.get().getModEventBus());
        LivingEntityInit.ENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
        FluidInit.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CallEvents {

        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent e){
            BlockEntityScreenRender.screenRender(e);
            ClientBlockRenderingEvent.clientRenderingForBlock(e);
            FluidRenderLayer.renderFluidLayer(e);
        }

        @SubscribeEvent
        public static void registerRenderer(EntityRenderersEvent.RegisterRenderers entityRenderersEvent){
            entityRenderersEvent.registerEntityRenderer(MiscEntityInit.CANDY_TNT.get(), CandyTntEntityRenderer::new);
        }

        @SubscribeEvent
        public static void AttributeCreation(EntityAttributeCreationEvent e){
            AttributeEvents.registerAttributeForOurEntity(e);
        }

        @SubscribeEvent
        public static void AttributeModification(EntityAttributeModificationEvent e){
            AttributeEvents.registerAttribute(e);
        }
    }
}
