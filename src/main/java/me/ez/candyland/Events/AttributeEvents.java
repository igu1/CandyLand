package me.ez.candyland.Events;

import me.ez.candyland.Common.Entites.CandyCow.CandyCow;
import me.ez.candyland.Init.LivingEntityInit;
import me.ez.candyland.Main;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
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
        System.out.println("Creating Attributes");
        e.put(LivingEntityInit.CANDY_COW.get(), CandyCow.createAttributes().build());
    }
}
