package me.ez.candyland.Common.Block.Decoration;

import me.ez.candyland.Init.Iteminit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Item;

import java.util.List;

public class LyingCandies extends Block {

    public LyingCandies(Properties properties) {
        super(properties);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState state1, boolean b) {
        List<Item> itemList = List.of(
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

        for (int x = 0; x < 2; x++) {
            popResource(level,
                    pos,
                    new ItemStack(itemList.get(x + level.random.nextInt(0, itemList.size()))));
        }
    }


}
