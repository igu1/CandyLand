package me.ez.candyland.Init;

import me.ez.candyland.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidInit {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Main.MOD_ID);

    //Chocolate Fluid
    public static final ForgeFlowingFluid.Properties CHOCOLATE_FLUID_PROP =
            new ForgeFlowingFluid.Properties(() -> FluidInit.CHOCOLATE.get(), () -> FluidInit.FLOWING_CHOCOLATE.get(), FluidAttributes.builder(
            new ResourceLocation("block/water_still"), new ResourceLocation("block/water_flow"))
            .density(15)
            .luminosity(2)
            .viscosity(5)
            .sound(SoundEvents.HONEY_DRINK)
            .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY)
            .overlay(new ResourceLocation("block/water_overlay"))
//            .color(0x873814)
                    .color(0xbf7A2E14)
            )
            .levelDecreasePerBlock(2)
            .slopeFindDistance(2)
            .block(() -> Blockinit.CHOCOLATE_BLOCK.get())
            .bucket(() -> Iteminit.CHOCOLATE_BUCKET.get());

    public static final RegistryObject<FlowingFluid> FLOWING_CHOCOLATE = FLUIDS.register("flowing_chocolate",() -> new ForgeFlowingFluid.Flowing(CHOCOLATE_FLUID_PROP));
    public static final RegistryObject<FlowingFluid> CHOCOLATE = FLUIDS.register("chocolate", () -> new ForgeFlowingFluid.Source(FluidInit.CHOCOLATE_FLUID_PROP));

}
