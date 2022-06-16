package me.ez.candyland.Common.BlockEntities.CandyMobExtractor;

import me.ez.candyland.Common.AbstractContainerBlockEntity.AbstractBlockEntityContainer;
import me.ez.candyland.Init.Blockinit;
import me.ez.candyland.Init.ContainerInit;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class CandyMobExtractorContainer extends AbstractBlockEntityContainer {


    public CandyMobExtractorContainer(int windowId, Inventory inventory ,BlockEntity blockEntity) {
        super(ContainerInit.CANDY_EXTRACTOR.get(), windowId, blockEntity, Blockinit.CANDY_MOB_EXTRACTOR.get(), 9);

        playerInventory(inventory);
        playerHotBar(inventory);

        blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
            for(int i = 0; i < 3; ++i) {
                for(int j = 0; j < 3; ++j) {
                    this.addSlot(new SlotItemHandler(h, j + i * 3, 62 + j * 18, 17 + i * 18));
                }
            }
        });
    }

    public CandyMobExtractorContainer(int windowId, Inventory inventory, FriendlyByteBuf data) {
        this(windowId, inventory, inventory.player.level.getBlockEntity(data.readBlockPos()));
    }


    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return takeNormalMoveStack(player, index, 9);
    }
}