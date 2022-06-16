//package me.ez.candyland.Common.Fluids;
//
//import me.ez.candyland.Init.Blockinit;
//import me.ez.candyland.Init.FluidInit;
//import me.ez.candyland.Init.Iteminit;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.core.particles.ParticleOptions;
//import net.minecraft.core.particles.ParticleTypes;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LevelAccessor;
//import net.minecraft.world.level.LevelReader;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.LiquidBlock;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.material.FlowingFluid;
//import net.minecraft.world.level.material.Fluid;
//import net.minecraft.world.level.material.FluidState;
//
//import javax.annotation.Nullable;
//import java.util.Optional;
//import java.util.Random;
//
//public class ChocolateFluid extends FlowingFluid {
//
//    @Override
//    public Fluid getFlowing() {
//        return FluidInit.FLOWING_CHOCOLATE.get();
//    }
//    @Override
//    public Fluid getSource() {
//        return FluidInit.CHOCOLATE.get();
//    }
//    @Override
//    public Item getBucket() {
//        return Iteminit.CHOCOLATE_BUCKET.get();
//    }
//    @Override
//    public void animateTick(Level level, BlockPos pos, FluidState fluidState, Random random) {
//        if (!fluidState.isSource() && !fluidState.getValue(FALLING)) {
//            if (random.nextInt(64) == 0) {
//                level.playLocalSound((double)pos.getX() + 0.5D,
//                        (double)pos.getY() + 0.5D,
//                        (double)pos.getZ() + 0.5D,
//                        SoundEvents.WATER_AMBIENT,
//                        SoundSource.BLOCKS,
//                        random.nextFloat() * 0.25F + 0.75F,
//                        random.nextFloat() + 0.5F,
//                        false);
//            }
//        } else if (random.nextInt(10) == 0) {
//            level.addParticle(ParticleTypes.UNDERWATER,
//                    (double)pos.getX() + random.nextDouble(),
//                    (double)pos.getY() + random.nextDouble(),
//                    (double)pos.getZ() + random.nextDouble(),
//                    0.0D,
//                    0.0D,
//                    0.0D);
//        }
//
//    }
//    @Override
//    @Nullable
//    public ParticleOptions getDripParticle() {
//        return null;
//    }
//    @Override
//    protected boolean canConvertToSource() {
//        return false;
//    }
//
//    @Override
//    protected void beforeDestroyingBlock(LevelAccessor levelAccessor, BlockPos pos, BlockState state) {
//        BlockEntity blockentity = state.hasBlockEntity() ? levelAccessor.getBlockEntity(pos) : null;
//        Block.dropResources(state, levelAccessor, pos, blockentity);
//    }
//
//    @Override
//    public int getSlopeFindDistance(LevelReader reader) {
//        return 4;
//    }
//
//    @Override
//    public BlockState createLegacyBlock(FluidState fluidState) {
//        return Blockinit.CHOCOLATE_BLOCK.get().defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(fluidState));
//    }
//
//    @Override
//    public boolean isSource(FluidState p_76140_) {
//        return false;
//    }
//    @Override
//    public boolean isSame(Fluid fluid) {
//        return fluid == FluidInit.CHOCOLATE.get() || fluid == FluidInit.FLOWING_CHOCOLATE.get();
//    }
//    @Override
//    public int getDropOff(LevelReader levelReader) {
//        return 1;
//    }
//
//    @Override
//    public int getAmount(FluidState fluidState) {
//        return 0;
//    }
//    @Override
//    public int getTickDelay(LevelReader p_76120_) {
//        return 5;
//    }
//    @Override
//    public boolean canBeReplacedWith(FluidState fluidState, BlockGetter blockGetter, BlockPos pos, Fluid fluid, Direction p_76462_) {
//        return false;
//    }
//    @Override
//    protected float getExplosionResistance() {
//        return 100.0F;
//    }
//    @Override
//    public Optional<SoundEvent> getPickupSound() {
//        return Optional.of(SoundEvents.BUCKET_FILL);
//    }
//
//    public static class Flowing extends ChocolateFluid {
//        @Override
//        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
//            super.createFluidStateDefinition(builder);
//            builder.add(LEVEL);
//        }
//        @Override
//        public int getAmount(FluidState state) {
//            return state.getValue(LEVEL);
//        }
//        @Override
//        public boolean isSource(FluidState state) {
//            return false;
//        }
//    }
//
//    public static class Source extends ChocolateFluid {
//        @Override
//        public int getAmount(FluidState fluidState) {
//            return 8;
//        }
//        @Override
//        public boolean isSource(FluidState fluidState) {
//            return false;
//        }
//    }
//}
