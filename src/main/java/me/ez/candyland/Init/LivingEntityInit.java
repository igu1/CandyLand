package me.ez.candyland.Init;

import me.ez.candyland.Common.Entites.CandyCow.CandyCow;
import me.ez.candyland.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LivingEntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MOD_ID);

    public static final RegistryObject<EntityType<CandyCow>> CANDY_COW =
            ENTITY.register("candy_cow",
                    () -> EntityType.Builder.of(CandyCow::new,
                            MobCategory.CREATURE).build(new ResourceLocation(Main.MOD_ID, "candy_cow").toString()));
}
