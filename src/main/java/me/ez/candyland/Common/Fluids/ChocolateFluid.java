package me.ez.candyland.Common.Fluids;

import me.ez.candyland.Init.FluidInit;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

@SuppressWarnings("all")
public class ChocolateFluid extends ForgeFlowingFluid.Properties {
    public ChocolateFluid(FluidAttributes.Builder attributes) {
        super(() -> FluidInit.CHOCOLATE.get(), () -> FluidInit.FLOWING_CHOCOLATE.get(), attributes);
    }
}
