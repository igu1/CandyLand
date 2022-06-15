package me.ez.candyland.Common.Block;

import me.ez.candyland.Init.Iteminit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class ExplodingCandyOre extends Block {

    public ExplodingCandyOre(Properties properties) {
        super(properties);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState state1, boolean p_60519_) {
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
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 1.0F, Explosion.BlockInteraction.NONE);
        int randint = level.random.nextInt(0, 12);
        for (int x = 0; x < randint; x++){
            popResource(level, pos, new ItemStack(candy.get(level.random.nextInt(candy.size()))));
        }
        if (randint > 9){
            popResource(level, pos, new ItemStack(Iteminit.CANDY_GUNPOWDER.get(), level.random.nextInt(4)));
        }
    }
}
