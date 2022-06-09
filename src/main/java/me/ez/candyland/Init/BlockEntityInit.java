package me.ez.candyland.Init;

import me.ez.candyland.Common.BlockEntities.CandyMobExtractorBlockEntity;
import me.ez.candyland.Main;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITY_TYPE = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Main.MOD_ID);

    public static final RegistryObject<BlockEntityType<CandyMobExtractorBlockEntity>> CANDY_MOB_EXTRACTOR = BLOCKENTITY_TYPE.register("candy_mob_extractor", () -> BlockEntityType.Builder.of(CandyMobExtractorBlockEntity::new, Blockinit.CANDY_MOB_EXTRACTOR.get()).build(null));
}
