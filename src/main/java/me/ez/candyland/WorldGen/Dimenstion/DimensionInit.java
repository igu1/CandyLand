package me.ez.candyland.WorldGen.Dimenstion;

import me.ez.candyland.Main;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;

public class DimensionInit {
    public static ResourceKey<Level> CandyLand = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Main.MOD_ID, "candy_land"));

}
