package me.ez.candyland.Common.Block;

import me.ez.candyland.Init.Iteminit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class GiftBox extends Block {


    private static final Random rand = new Random();

    private static final List<ItemStack> gift_drops = List.of(
//            new ItemStack(Iteminit.BLUE_CANDY.get(), rand.nextInt(7)),
//            new ItemStack(Iteminit.RED_CANDY.get(),rand.nextInt(6)),
//            new ItemStack(Iteminit.YELLOW_CANDY.get(),rand.nextInt(8)),
//            new ItemStack(Iteminit.GREEN_CANDY.get(),rand.nextInt(7)),
//            new ItemStack(Iteminit.CYAN_CANDY.get(), rand.nextInt(6)),
//            new ItemStack(Iteminit.MAGENTA_CANDY.get(),rand.nextInt(5)),
//            new ItemStack(Iteminit.LIGHT_BLUE_CANDY.get(),rand.nextInt(8)),
//            new ItemStack(Iteminit.LIME_CANDY.get(),rand.nextInt(7)),
//            new ItemStack(Iteminit.BROWN_CANDY.get(), rand.nextInt(6)),
//            new ItemStack(Iteminit.WHITE_CANDY.get(),rand.nextInt(5)),
//            new ItemStack(Iteminit.PINK_CANDY.get(),rand.nextInt(8)),
//            new ItemStack(Iteminit.ORANGE_CANDY.get(),rand.nextInt(7)),
//            new ItemStack(Iteminit.PURPLE_CANDY.get(), rand.nextInt(6)),
//            new ItemStack(Iteminit.LOLLIPOP.get(), rand.nextInt(4)),
//
//            new ItemStack(Items.DIAMOND, rand.nextInt(2)),
//            new ItemStack(Items.EMERALD, rand.nextInt(2)),
//            new ItemStack(Items.GOLD_INGOT, rand.nextInt(3)),
//            new ItemStack(Items.IRON_INGOT, rand.nextInt(5)),
//            new ItemStack(Items.COAL, rand.nextInt(10)),
//            new ItemStack(Iteminit.CANDY_GUNPOWDER.get(), rand.nextInt(4))
            );

    public GiftBox(Properties properties) {
        super(properties);
    }

    private static final Optional<VoxelShape> SHAPE = Stream.of(
            Block.box(3, 0, 3, 13, 6, 13),
            Block.box(2, 6, 2, 14, 10, 14),
            Block.box(1, 10, 7, 15, 11, 9),
            Block.box(7, 10, 1, 9, 11, 15),
            Block.box(13, 5, 7, 14, 6, 9),
            Block.box(14, 5, 7, 15, 10, 9),
            Block.box(7, 5, 1, 9, 10, 2),
            Block.box(7, 5, 2, 9, 6, 3),
            Block.box(7, 5, 13, 9, 6, 14),
            Block.box(7, 5, 14, 9, 10, 15),
            Block.box(2, 5, 7, 3, 6, 9),
            Block.box(1, 5, 7, 2, 10, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR));

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext p_60558_) {
        return SHAPE.orElse(Shapes.block());
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState state1, boolean p_60519_) {
        for (int x = 0; x < rand.nextInt(4, 8); x++){
            popResource(level, pos, gift_drops.get(rand.nextInt(0, gift_drops.size())));
        }
    }
}
