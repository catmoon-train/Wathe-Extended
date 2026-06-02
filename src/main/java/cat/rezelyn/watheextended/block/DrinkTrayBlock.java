package cat.rezelyn.watheextended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DrinkTrayBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<DrinkTrayBlock> CODEC = simpleCodec(DrinkTrayBlock::new);
    private static final VoxelShape SHAPE = box(2, 0, 2, 14, 3, 14);
    public DrinkTrayBlock(Properties s) { super(s); registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH)); }
    @Override protected MapCodec<? extends HorizontalDirectionalBlock> codec() { return CODEC; }
    @Override protected VoxelShape getShape(BlockState s, BlockGetter w, BlockPos p, CollisionContext c) { return SHAPE; }
    @Override public BlockState getStateForPlacement(BlockPlaceContext c) { return defaultBlockState().setValue(FACING, c.getHorizontalDirection()); }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) { b.add(FACING); }
}
