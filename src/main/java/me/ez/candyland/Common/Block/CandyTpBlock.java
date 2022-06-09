//package me.ez.candyland.Common.Block;
//
//import me.ez.candyland.WorldGen.Dimenstion.CandyTeleporter;
//import me.ez.candyland.WorldGen.Dimenstion.DimensionInit;
//import net.minecraft.core.BlockPos;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.phys.BlockHitResult;
//
//public class CandyTpBlock extends Block {
//
//    public CandyTpBlock(Properties properties) {
//        super(properties);
//    }
//
//    @Override
//    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand p_60507_, BlockHitResult p_60508_) {
//        if (!level.isClientSide()) {
//            if (!player.isCrouching()) {
//                MinecraftServer server = level.getServer();
//
//                if (server != null) {
//                    if (level.dimension() == DimensionInit.CandyLand) {
//                        ServerLevel overWorld = server.getLevel(Level.OVERWORLD);
//                        if (overWorld != null) {
//                            player.changeDimension(overWorld, new CandyTeleporter(pos, false));
//                        }
//                    } else {
//                        ServerLevel kjDim = server.getLevel(DimensionInit.CandyLand);
//                        if (kjDim != null) {
//                            player.changeDimension(kjDim, new CandyTeleporter(pos, true));
//                        }
//                    }
//                    return InteractionResult.SUCCESS;
//                }
//            }
//        }
//
//        return super.use(state, level, pos, player, p_60507_, p_60508_);
//    }
//}
