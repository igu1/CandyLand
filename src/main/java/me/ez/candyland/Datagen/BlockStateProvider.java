package me.ez.candyland.Datagen;

import me.ez.candyland.Init.Blockinit;
import me.ez.candyland.Main;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {

    public BlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Main.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        simpleBlock(Blockinit.CANDY_ORE.get());
//        simpleBlock(Blockinit.DEEPSLATE_CANDY_ORE.get());
//        simpleBlock(Blockinit.CANDY_IRON_ORE.get());
//        simpleBlock(Blockinit.DEEPSLATE_CANDY_IRON_ORE.get());
//        simpleBlock(Blockinit.CANDY_GOLD_ORE.get());
//        simpleBlock(Blockinit.DEEPSLATE_CANDY_GOLD_ORE.get());
//        simpleBlock(Blockinit.CANDY_DIAMOND_ORE.get());
//        simpleBlock(Blockinit.DEEPSLATE_CANDY_DIAMOND_ORE.get());
//        simpleBlock(Blockinit.CANDY_EMERALD_ORE.get());
//        simpleBlock(Blockinit.DEEPSLATE_CANDY_EMERALD_ORE.get());
    }
}
