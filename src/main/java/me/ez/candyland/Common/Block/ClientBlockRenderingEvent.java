package me.ez.candyland.Common.Block;

import me.ez.candyland.Init.Blockinit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientBlockRenderingEvent {

    public static void clientRenderingForBlock(FMLClientSetupEvent e){
        ItemBlockRenderTypes.setRenderLayer(Blockinit.BLUE_GIFT_BOX.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Blockinit.RED_GIFT_BOX.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Blockinit.GREEN_GIFT_BOX.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Blockinit.YELLOW_GIFT_BOX.get(), RenderType.cutout());
    }
}
