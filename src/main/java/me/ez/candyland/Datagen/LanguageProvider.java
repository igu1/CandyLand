package me.ez.candyland.Datagen;

import me.ez.candyland.Init.Iteminit;
import me.ez.candyland.Main;
import net.minecraft.data.DataGenerator;

public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider {

    public LanguageProvider(DataGenerator gen, String locale) {
        super(gen, Main.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(Iteminit.CHOCOLATE_BUCKET.get(), "Chocolate Bucket");
    }
}
