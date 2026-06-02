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

public class LedgeBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<LedgeBlock> CODEC = simpleCodec(LedgeBlock::new);
    private static final VoxelShape NORTH = box(0, 14, 14, 16, 16, 16);
    private static final VoxelShape SOUTH = box(0, 14, 0, 16, 16, 2);
    private static final VoxelShape WEST  = box(14, 14, 0, 16, 16, 16);
    private static final VoxelShape EAST  = box(0, 14, 0, 2, 16, 16);

    public LedgeBlock(Properties s) { super(s); registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH)); }
    @Override public MapCodec<? extends HorizontalDirectionalBlock> codec() { return CODEC; }
    @Override public BlockState getStateForPlacement(BlockPlaceContext c) { return defaultBlockState().setValue(FACING, c.getHorizontalDirection()); }
    @Override protected VoxelShape getShape(BlockState s, BlockGetter w, BlockPos p, CollisionContext c) {
        return switch(s.getValue(FACING)) { case NORTH->NORTH; case SOUTH->SOUTH; case WEST->WEST; case EAST->EAST; default->NORTH; };
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) { b.add(FACING); }
}
