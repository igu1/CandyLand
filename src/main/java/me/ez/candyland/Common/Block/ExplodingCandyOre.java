package me.ez.candyland.Common.Block;

import me.ez.candyland.Init.Iteminit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;

import java.util.List;
import java.util.Random;

public class ExplodingCandyOre extends Block {

    private Random rand = new Random();
//    List<ItemStack> candies = List.of(new ItemStack[]{
//            new ItemStack(Iteminit.BLUE_CANDY.get()),
//            new ItemStack(Iteminit.RED_CANDY.get()),
//            new ItemStack(Iteminit.YELLOW_CANDY.get()),
//            new ItemStack(Iteminit.GREEN_CANDY.get()),
//            new ItemStack(Iteminit.LOLLIPOP.get())
//    });

    public ExplodingCandyOre(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 1.0F, Explosion.BlockInteraction.NONE);
        int r = rand.nextInt(6, 12);
        for (int x = 0; x < r; x++){
//            ItemEntity item = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), candies.get(rand.nextInt(0, candies.size())));
//            level.addFreshEntity(item);
        }
        if (r > 9){
//            ItemEntity item = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Iteminit.CANDY_GUNPOWDER.get()));
//            level.addFreshEntity(item);
        }
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
