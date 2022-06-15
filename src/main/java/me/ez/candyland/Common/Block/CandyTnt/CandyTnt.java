package me.ez.candyland.Common.Block.CandyTnt;

import me.ez.candyland.Common.Block.CandyTnt.Entity.CandyPrimedTnt;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class CandyTnt extends Block {

    public CandyTnt(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.UNSTABLE, Boolean.FALSE));
    }
    @Override
    public void onCaughtFire(BlockState state, Level world, BlockPos pos, @Nullable net.minecraft.core.Direction face, @Nullable LivingEntity igniter) {
        explode(world, pos, igniter);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState state1, boolean p_57470_) {
        if (!state1.is(state.getBlock())) {
            if (level.hasNeighborSignal(pos)) {
                onCaughtFire(state, level, pos, null, null);
                level.removeBlock(pos, false);
            }

        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos pos1, boolean p_57462_) {
        if (level.hasNeighborSignal(pos)) {
            onCaughtFire(state, level, pos, null, null);
            level.removeBlock(pos, false);
        }

    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide() && !player.isCreative() && state.getValue(BlockStateProperties.UNSTABLE)) {
            onCaughtFire(state, level, pos, null, null);
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void wasExploded(Level level, BlockPos pos, Explosion explosion) {
        if (!level.isClientSide) {
            PrimedTnt primedtnt = new PrimedTnt(level, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, explosion.getSourceMob());
            int i = primedtnt.getFuse();
            primedtnt.setFuse((short)(level.random.nextInt(i / 4) + i / 8));
            level.addFreshEntity(primedtnt);
        }
    }

    public static void explode(Level level, BlockPos pos) {
        explode(level, pos, null);
    }

    private static void explode(Level level, BlockPos pos, @Nullable LivingEntity entity) {
        if (!level.isClientSide) {
            CandyPrimedTnt candyPrimedTnt = new CandyPrimedTnt(level, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, entity);
            level.addFreshEntity(candyPrimedTnt);
            level.playSound(null, candyPrimedTnt.getX(), candyPrimedTnt.getY(), candyPrimedTnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(entity, GameEvent.PRIME_FUSE, pos);
        }
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult hitResult) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (!itemstack.is(Items.FLINT_AND_STEEL) && !itemstack.is(Items.FIRE_CHARGE)) {
            return super.use(state, level, pos, player, interactionHand, hitResult);
        } else {
            onCaughtFire(state, level, pos, hitResult.getDirection(), player);
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
            Item item = itemstack.getItem();
            if (!player.isCreative()) {
                if (itemstack.is(Items.FLINT_AND_STEEL)) {
                    itemstack.hurtAndBreak(1, player, (flint_and_steel) -> {
                        flint_and_steel.broadcastBreakEvent(interactionHand);
                    });
                } else {
                    itemstack.shrink(1);
                }
            }

            player.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    @Override
    public void onProjectileHit(Level level, BlockState state, BlockHitResult hitResult, Projectile projectile) {
        if (!level.isClientSide) {
            BlockPos blockpos = hitResult.getBlockPos();
            Entity entity = projectile.getOwner();
            if (projectile.isOnFire() && projectile.mayInteract(level, blockpos)) {
                onCaughtFire(state, level, blockpos, null, entity instanceof LivingEntity ? (LivingEntity)entity : null);
                level.removeBlock(blockpos, false);
            }
        }

    }

    @Override
    public boolean dropFromExplosion(Explosion explosion) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(BlockStateProperties.UNSTABLE);
    }
}

