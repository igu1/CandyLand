package me.ez.candyland.Util;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class InventoryUtil {

    public static void addItemToInventory(IItemHandler h, Item item, int amount) {
        int slots = h.getSlots();
        for (int x = 0; x < slots; x++){
            if (h.getStackInSlot(x).is(item) || h.getStackInSlot(x).isEmpty()) {
                if (h.getStackInSlot(x).getCount() < 64) {
                    h.insertItem(x, new ItemStack(item, amount), false);
                    break;
                }
            }
        }
    }
    public static boolean checkIsItemInInventory(IItemHandler h, Item item){
        boolean found = false;
        int numberOfSlots = h.getSlots();
        for (int x = 0; x < numberOfSlots; x++) {
            if (h.getStackInSlot(x).is(item)){
                found = true;
                break;
            }
        }
        return found;
    }
}
