package me.ez.candyland.Init;

import me.ez.candyland.Common.Block.GiftBox;
import me.ez.candyland.Common.BlockEntities.CandyMobExtractorBlock;
import me.ez.candyland.Main;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Blockinit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> CANDY_ORE = registerBlock(
            "candy_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CANDY_ORE = registerBlock(
            "deepslate_candy_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);


    public static final RegistryObject<Block> CANDY_IRON_ORE = registerBlock(
            "candy_iron_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CANDY_IRON_ORE = registerBlock(
            "deepslate_candy_iron_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);


    public static final RegistryObject<Block> CANDY_GOLD_ORE = registerBlock(
            "candy_gold_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CANDY_GOLD_ORE = registerBlock(
            "deepslate_candy_gold_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);


    public static final RegistryObject<Block> CANDY_DIAMOND_ORE = registerBlock(
            "candy_diamond_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CANDY_DIAMOND_ORE = registerBlock(
            "deepslate_candy_diamond_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CANDY_EMERALD_ORE = registerBlock(
            "candy_emerald_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CANDY_EMERALD_ORE = registerBlock(
            "deepslate_candy_emerald_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    //Gift Block
    public static final RegistryObject<GiftBox> RED_GIFT_BOX = registerBlock(
        "red_gift_box",
        () -> new GiftBox(BlockBehaviour.Properties.of(Material.CAKE).instabreak()),
                CreativeModeTab.TAB_MISC);

    public static final RegistryObject<GiftBox> BLUE_GIFT_BOX = registerBlock(
            "blue_gift_box",
            () -> new GiftBox(BlockBehaviour.Properties.of(Material.CAKE)),
            CreativeModeTab.TAB_MISC);

    public static final RegistryObject<GiftBox> YELLOW_GIFT_BOX = registerBlock(
            "yellow_gift_box",
            () -> new GiftBox(BlockBehaviour.Properties.of(Material.CAKE)),
            CreativeModeTab.TAB_MISC);

    public static final RegistryObject<GiftBox> GREEN_GIFT_BOX = registerBlock(
            "green_gift_box",
            () -> new GiftBox(BlockBehaviour.Properties.of(Material.CAKE)),
            CreativeModeTab.TAB_MISC);

    public static final RegistryObject<CandyMobExtractorBlock> CANDY_MOB_EXTRACTOR = registerBlock(
            "candy_mob_extractor",
            () -> new CandyMobExtractorBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> supplier, CreativeModeTab tab) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        Iteminit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        return block;
    }


}
