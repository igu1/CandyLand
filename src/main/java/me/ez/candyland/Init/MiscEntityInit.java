package me.ez.candyland.Init;

import me.ez.candyland.Common.Block.CandyTnt.Entity.CandyPrimedTnt;
import me.ez.candyland.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MiscEntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MOD_ID);

    public static final RegistryObject<EntityType<CandyPrimedTnt>> CANDY_TNT =
            ENTITY.register("candy_tnt",
                    () -> EntityType.Builder.<CandyPrimedTnt>of(CandyPrimedTnt::new, MobCategory.MISC).fireImmune().sized(0.98F, 0.98F).clientTrackingRange(10).updateInterval(10)
                            .build(new ResourceLocation(Main.MOD_ID, "candy_tnt").toString()));
}
