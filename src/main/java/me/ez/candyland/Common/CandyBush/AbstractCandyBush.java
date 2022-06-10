package me.ez.candyland.Common.CandyBush;

import me.ez.candyland.Init.Iteminit;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.List;

public class AbstractCandyBush extends SweetBerryBushBlock {

    public AbstractCandyBush(Properties properties) {
        super(properties);
    }

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

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return Iteminit.COCO_BUSH_SEEDS.get().getDefaultInstance();
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult p_57280_) {
        int i = state.getValue(AGE);
        ItemStack stack = new ItemStack(this.candy.get(level.random.nextInt(this.candy.size())), level.random.nextInt(1,3));
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos, stack);
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(AGE, 1), 2);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(state, level, pos, player, hand, p_57280_);
        }
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {}


}

