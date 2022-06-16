package me.ez.candyland.Common.Fluids;

import me.ez.candyland.Init.Blockinit;
import me.ez.candyland.Init.FluidInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class FluidRenderLayer {

    public static void renderFluidLayer(FMLClientSetupEvent e){
        System.out.println("Registering Fluid Render Layer");
        //Chocolate Fluid

        ItemBlockRenderTypes.setRenderLayer(FluidInit.CHOCOLATE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidInit.FLOWING_CHOCOLATE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(Blockinit.CHOCOLATE_BLOCK.get(), RenderType.translucent());

        //---------------
    }
}
