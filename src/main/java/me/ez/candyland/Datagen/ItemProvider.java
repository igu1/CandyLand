package me.ez.candyland.Datagen;

import me.ez.candyland.Init.Iteminit;
import me.ez.candyland.Main;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemProvider extends ItemModelProvider {
    public ItemProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Main.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Iteminit.CANDIES.getEntries().forEach(item -> simpleItem(item.get()));
//        Iteminit.ITEMS.getEntries().forEach(item -> simpleItem(item.get()));
    }
    private ItemModelBuilder simpleItem(Item item){
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0",
        new ResourceLocation(Main.MOD_ID, "item/" + item.getRegistryName().getPath()));
    }
}
