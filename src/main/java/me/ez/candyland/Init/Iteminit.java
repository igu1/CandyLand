package me.ez.candyland.Init;

import me.ez.candyland.Main;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Iteminit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

//    //Items
    public static final RegistryObject<Item> RED_CANDY = registerCandy("red_candy", 0.1f, 1);

    public static final RegistryObject<Item> GREEN_CANDY = registerCandy("green_candy", 0.1f, 1);

    public static final RegistryObject<Item> YELLOW_CANDY = registerCandy("yellow_candy", 0.1f, 1);

    public static final RegistryObject<Item> BLUE_CANDY = registerCandy("blue_candy", 0.1f, 1);

    public static final RegistryObject<Item> LOLLIPOP = registerCandy("lollipop", 0.2f, 2);

    private static <T extends Item> RegistryObject<Item> registerCandy(String name, Float saturation, int nutrition){
        return ITEMS.register(name, () -> new Item(new Item.Properties()
                .food(new FoodProperties.Builder()
                        .fast()
                        .saturationMod(0.1F)
                        .nutrition(1)
                        .build())
                .tab(CreativeModeTab.TAB_FOOD)));
    }

////    Materials
    public static final RegistryObject<Item> DIAMOND_EMERALD_ALLOY = ITEMS.register("dia_eme_alloy",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CANDIUM = ITEMS.register("candium",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CANDY_GUNPOWDER = ITEMS.register("candy_gunpowder",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .tab(CreativeModeTab.TAB_MISC)));

}
