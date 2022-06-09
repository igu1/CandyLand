package me.ez.candyland.Util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraft.world.item.Item;
import net.minecraftforge.items.IItemHandler;

public class InventoryUtil {

    public static <T extends BlockEntity> void addItemToInventory(IItemHandler h, Item item, int amount) {
        int slots = h.getSlots();
        for (int x = 0; x < slots; x++){
            if (h.getStackInSlot(x).isEmpty() || h.getStackInSlot(x).is(item) && h.getSlotLimit(x) < 64) {
                h.insertItem(x, new ItemStack(item, amount), false);
                break;
            }
        }
    }
}
