package me.ez.candyland.Common.BlockEntities;

import me.ez.candyland.Common.AbstractContainerBlockEntity.AbstractBlockEntityScreen;
import me.ez.candyland.Init.BlockEntityInit;
import me.ez.candyland.Init.Iteminit;
import me.ez.candyland.Main;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.CapabilityItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class CandyMobExtractorScreen extends AbstractBlockEntityScreen<CandyMobExtractorContainer> {

    public CandyMobExtractorScreen(CandyMobExtractorContainer generatorContainer, Inventory inventory, Component component) {
        super(generatorContainer, inventory, component, Main.MOD_ID, "textures/gui/container/candy_mob_extractor.png");
    }
}
