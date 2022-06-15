package me.ez.candyland.Events;

import me.ez.candyland.Init.AttributeInit;
import me.ez.candyland.Main;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class AttributeEvents {

    @SubscribeEvent
    public static void registerAttribute(EntityAttributeModificationEvent e){
        System.out.println("Registering Attributes");
        // For Vanilla Entity
    }

    @SubscribeEvent
    public static void registerAttributeForOurEntity(EntityAttributeCreationEvent e){
        System.out.println("Registering Attributes");
        // For Our Entity Entity
    }
}
