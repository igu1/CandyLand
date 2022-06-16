package me.ez.candyland.Common.BlockEntities.CandyMobExtractor;

import me.ez.candyland.Common.AbstractContainerBlockEntity.AbstractContainerBlockEntity;
import me.ez.candyland.Init.BlockEntityInit;
import me.ez.candyland.Init.Iteminit;
import me.ez.candyland.Util.InventoryUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.CapabilityItemHandler;

import java.util.List;
import java.util.Random;

public class CandyMobExtractorBlockEntity extends AbstractContainerBlockEntity {

    public CandyMobExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.CANDY_MOB_EXTRACTOR.get(), pos, state, "Candy Extractor", 9);
    }

    int ticker;

    List<Item> candy = List.of(
            Iteminit.BLUE_CANDY.get(),
            Iteminit.RED_CANDY.get(),
            Iteminit.YELLOW_CANDY.get(),
            Iteminit.GREEN_CANDY.get(),
            Iteminit.LOLLIPOP.get(),
            Iteminit.LIGHT_BLUE_CANDY.get(),
            Iteminit.PURPLE_CANDY.get(),
            Iteminit.WHITE_CANDY.get(),
            Iteminit.BROWN_CANDY.get(),
            Iteminit.ORANGE_CANDY.get(),
            Iteminit.PINK_CANDY.get(),
            Iteminit.CYAN_CANDY.get(),
            Iteminit.LIME_CANDY.get(),
            Iteminit.MAGENTA_CANDY.get());


    public static <T extends BlockEntity> void tickServer(Level lvl, BlockPos pos, BlockState blockstate, T t) {
        if (!lvl.isClientSide) {
            CandyMobExtractorBlockEntity candyMobExtractorBlockEntity = (CandyMobExtractorBlockEntity) t;
            candyMobExtractorBlockEntity.ticker++;
            if (candyMobExtractorBlockEntity.ticker > 40) {
                candyMobExtractorBlockEntity.ticker = 0;
                List<Mob> entities = lvl.getEntitiesOfClass(Mob.class, t.getRenderBoundingBox().inflate(3.0D, 3.0D, 3.0D));
                for (Mob entity : entities) {
                    if (entity.getHealth() > 2.0F && !entity.isBaby()) {
                        entity.hurt(DamageSource.MAGIC, 1.0F);
                        lvl.addParticle(ParticleTypes.HAPPY_VILLAGER, entity.getX(), entity.getY() + 0.5D, entity.getZ(), 0.0D, 0.0D, 0.0D);
                        Random rand = new Random();
                        int randint = rand.nextInt(0, candyMobExtractorBlockEntity.candy.size());
                        ItemEntity itemEntity = new ItemEntity(lvl, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(candyMobExtractorBlockEntity.candy.get(randint)));
                        lvl.addFreshEntity(itemEntity);
                        break;
                    } else {
                        entity.kill();
                        candyMobExtractorBlockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
                            InventoryUtil.addItemToInventory(h, candyMobExtractorBlockEntity.candy.get(lvl.random.nextInt(0, candyMobExtractorBlockEntity.candy.size())), lvl.random.nextInt(5));
                        });
                    }
                }
            }
        }
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowid, Inventory inventory) {
        return new CandyMobExtractorContainer(windowid, inventory, this);
    }
}
