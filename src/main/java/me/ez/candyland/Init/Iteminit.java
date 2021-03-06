package me.ez.candyland.Init;

import me.ez.candyland.Common.Food.SmallFood;
import me.ez.candyland.Common.Item.ChocolateBucket;
import me.ez.candyland.Main;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Iteminit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
    public static final DeferredRegister<Item> CANDIES = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
    //Items
    public static final RegistryObject<Item> RED_CANDY = registerCandy("red_candy", 0.1f, 1);
    public static final RegistryObject<Item> WHITE_CANDY = registerCandy("white_candy", 0.1f, 1);
    public static final RegistryObject<Item> ORANGE_CANDY = registerCandy("orange_candy", 0.1f, 1);
    public static final RegistryObject<Item> MAGENTA_CANDY = registerCandy("magenta_candy", 0.1f, 1);
    public static final RegistryObject<Item> LIGHT_BLUE_CANDY = registerCandy("light_blue_candy", 0.1f, 1);
    public static final RegistryObject<Item> LIME_CANDY = registerCandy("lime_candy", 0.1f, 1);
    public static final RegistryObject<Item> PINK_CANDY = registerCandy("pink_candy", 0.1f, 1);
    public static final RegistryObject<Item> CYAN_CANDY = registerCandy("cyan_candy", 0.1f, 1);
    public static final RegistryObject<Item> PURPLE_CANDY = registerCandy("purple_candy", 0.1f, 1);
    public static final RegistryObject<Item> BROWN_CANDY = registerCandy("brown_candy", 0.1f, 1);
    public static final RegistryObject<Item> GREEN_CANDY = registerCandy("green_candy", 0.1f, 1);
    public static final RegistryObject<Item> YELLOW_CANDY = registerCandy("yellow_candy", 0.1f, 1);
    public static final RegistryObject<Item> BLUE_CANDY = registerCandy("blue_candy", 0.1f, 1);

    public static final RegistryObject<Item> LOLLIPOP = registerCandy("lollipop", 0.2f, 2);

    private static <T extends Item> RegistryObject<Item> registerCandy(String name, Float saturation, int nutrition){
        return CANDIES.register(name, () -> new SmallFood(saturation, nutrition));
    }

////    Materials
    public static final RegistryObject<Item> DIAMOND_EMERALD_ALLOY = ITEMS.register("dia_eme_alloy",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CANDIUM = ITEMS.register("candium",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .tab(CreativeModeTab.TAB_MISC))); // RAREST ORE + GOLD = CANDIUM

    public static final RegistryObject<Item> CANDY_GUNPOWDER = ITEMS.register("candy_gunpowder",
            () -> new Item(new Item.Properties()
                    .tab(CreativeModeTab.TAB_MISC))); //FROM CANDY CREEPER

    public static final RegistryObject<Item> CHOCOLATE_BUCKET =
            ITEMS.register("chocolate_bucket",
                    () -> new BucketItem(() -> FluidInit.CHOCOLATE.get() ,new Item.Properties()
                            .tab(CreativeModeTab.TAB_MISC).stacksTo(1)));
}
