package me.ez.candyland.Common.Food;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class SmallFood extends Item{

    public SmallFood(Float saturation, int nutrition) {
        super(new Item.Properties()
                .food(new FoodProperties.Builder()
                        .fast()
                        .saturationMod(saturation)
                        .nutrition(nutrition)
                        .build())
                .tab(CreativeModeTab.TAB_FOOD));
    }
}
