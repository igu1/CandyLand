//package me.ez.candyland.Common.Menu;
//
//import me.ez.candyland.Init.Blockinit;
//import me.ez.candyland.Init.Menuinit;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.inventory.ContainerLevelAccess;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraftforge.items.CapabilityItemHandler;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.SlotItemHandler;
//import net.minecraftforge.items.wrapper.InvWrapper;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.Objects;
//
//public class MixerMenu extends AbstractContainerMenu {
//
//    private BlockEntity blockEntity;
//    private Player player;
//    private IItemHandler playerinventory;
//
//    public MixerMenu(int windowId, Inventory inv, BlockPos pos) {
//        super(Menuinit.MIXER.get(), windowId);
//        blockEntity = inv.player.getCommandSenderWorld().getBlockEntity(pos);
//        this.player = inv.player;
//        this.playerinventory = new InvWrapper(inv);
//
//        if (blockEntity != null){
//            blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
//                addSlot(new SlotItemHandler(h, 0, 64, 24));
//                addSlot(new SlotItemHandler(h, 1, 64, 48));
//                addSlot(new SlotItemHandler(h, 2, 64, 62));
//            });
//        }
//
//        for(int i = 0; i < 3; ++i) {
//            for(int j = 0; j < 9; ++j) {
//                this.addSlot(new SlotItemHandler(playerinventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
//            }
//        }
//
//        for(int k = 0; k < 9; ++k) {
//            this.addSlot(new SlotItemHandler(playerinventory, k, 8 + k * 18, 142));
//        }
//
//    }
//
//    @Override
//    public boolean stillValid(@NotNull Player player1) {
//        return stillValid(ContainerLevelAccess.create(Objects.requireNonNull(blockEntity.getLevel()), blockEntity.getBlockPos()), player, Blockinit.MIXER.get());
//    }
//
//    @Override
//    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
//        return super.quickMoveStack(p_38941_, p_38942_);
//    }
//}
