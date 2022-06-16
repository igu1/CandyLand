package me.ez.candyland.Init;

import me.ez.candyland.Common.BlockEntities.CandyMobExtractor.CandyMobExtractorContainer;
import me.ez.candyland.Main;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ContainerInit {
    public static final DeferredRegister<MenuType<?>> MENUTYPE_TYPE = DeferredRegister.create(ForgeRegistries.CONTAINERS, Main.MOD_ID);

    public static final RegistryObject<MenuType<CandyMobExtractorContainer>> CANDY_EXTRACTOR = MENUTYPE_TYPE.register("candy_mob_extractor", () -> IForgeMenuType.create(CandyMobExtractorContainer::new));

}
