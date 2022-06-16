package me.ez.candyland.Common.BlockEntities.CandyMobExtractor;

import me.ez.candyland.Common.AbstractContainerBlockEntity.AbstractBlockEntityScreen;
import me.ez.candyland.Main;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class CandyMobExtractorScreen extends AbstractBlockEntityScreen<CandyMobExtractorContainer> {

    public CandyMobExtractorScreen(CandyMobExtractorContainer generatorContainer, Inventory inventory, Component component) {
        super(generatorContainer, inventory, component, Main.MOD_ID, "textures/gui/container/candy_mob_extractor.png");
    }
}
