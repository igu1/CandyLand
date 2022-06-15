package me.ez.candyland.Init;

import me.ez.candyland.Main;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AttributeInit {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, Main.MOD_ID);

    public static final RegistryObject<Attribute> EXPLODE_TICK =
            ATTRIBUTES.register("generic.explode_tick",
                    () -> new RangedAttribute("attribute.name.generic.explode_tick",
                            5.0D,
                            1.0D,
                            1024.0D).setSyncable(true));
}
