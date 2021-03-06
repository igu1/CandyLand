package me.ez.candyland.Init;

import me.ez.candyland.Common.Block.AbstractGiftBox;
import me.ez.candyland.Common.Block.CandyTnt.CandyTnt;
import me.ez.candyland.Common.Block.Decoration.LyingCandies;
import me.ez.candyland.Common.BlockEntities.CandyMobExtractor.CandyMobExtractorBlock;
import me.ez.candyland.Common.Fluids.ChocolateFluid;
import me.ez.candyland.Main;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Blockinit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> CANDY_ORE = registerBlockWithItem(
            "candy_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CANDY_ORE = registerBlockWithItem(
            "deepslate_candy_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);


    public static final RegistryObject<Block> CANDY_IRON_ORE = registerBlockWithItem(
            "candy_iron_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CANDY_IRON_ORE = registerBlockWithItem(
            "deepslate_candy_iron_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);


    public static final RegistryObject<Block> CANDY_GOLD_ORE = registerBlockWithItem(
            "candy_gold_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CANDY_GOLD_ORE = registerBlockWithItem(
            "deepslate_candy_gold_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);


    public static final RegistryObject<Block> CANDY_DIAMOND_ORE = registerBlockWithItem(
            "candy_diamond_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CANDY_DIAMOND_ORE = registerBlockWithItem(
            "deepslate_candy_diamond_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CANDY_EMERALD_ORE = registerBlockWithItem(
            "candy_emerald_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CANDY_EMERALD_ORE = registerBlockWithItem(
            "deepslate_candy_emerald_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    //Gift Block
    public static final RegistryObject<AbstractGiftBox> RED_GIFT_BOX = registerBlockWithItem(
        "red_gift_box",
        () -> new AbstractGiftBox(BlockBehaviour.Properties.of(Material.CAKE).instabreak()),
                CreativeModeTab.TAB_MISC);

    public static final RegistryObject<AbstractGiftBox> BLUE_GIFT_BOX = registerBlockWithItem(
            "blue_gift_box",
            () -> new AbstractGiftBox(BlockBehaviour.Properties.of(Material.CAKE)),
            CreativeModeTab.TAB_MISC);

    public static final RegistryObject<AbstractGiftBox> YELLOW_GIFT_BOX = registerBlockWithItem(
            "yellow_gift_box",
            () -> new AbstractGiftBox(BlockBehaviour.Properties.of(Material.CAKE)),
            CreativeModeTab.TAB_MISC);

    public static final RegistryObject<AbstractGiftBox> GREEN_GIFT_BOX = registerBlockWithItem(
            "green_gift_box",
            () -> new AbstractGiftBox(BlockBehaviour.Properties.of(Material.CAKE)),
            CreativeModeTab.TAB_MISC);

    public static final RegistryObject<CandyTnt> CANDY_TNT = registerBlockWithItem(
            "candy_tnt",
            () -> new CandyTnt(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    //-------------
//    BlockEntities
    public static final RegistryObject<CandyMobExtractorBlock> CANDY_MOB_EXTRACTOR = registerBlockWithItem(
            "candy_mob_extractor",
            () -> new CandyMobExtractorBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);


    //Decoration----------------------
    public static final RegistryObject<LyingCandies> LYING_CANDIES =
            registerBlock("lying_candies", () -> new LyingCandies(BlockBehaviour.Properties.of(Material.CAKE).instabreak().noCollission()));


    //Fluid Blocks------------------------
    @SuppressWarnings("all")
    public static final RegistryObject<LiquidBlock> CHOCOLATE_BLOCK = registerBlock("chocolate_block", () ->
            new LiquidBlock(() -> FluidInit.CHOCOLATE.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops()));


    private static <T extends Block> RegistryObject<T> registerBlockWithItem(String name, Supplier<T> supplier, CreativeModeTab tab) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        Iteminit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        return block;
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> supplier) {
        return BLOCKS.register(name, supplier);
    }



}
