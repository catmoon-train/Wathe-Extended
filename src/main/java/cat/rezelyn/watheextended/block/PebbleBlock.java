package cat.rezelyn.watheextended.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PebbleBlock extends Block {
    public static final IntegerProperty PEBBLES = IntegerProperty.create("pebbles", 1, 4);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape ONE = box(5, 0, 5, 11, 3, 11);
    private static final VoxelShape TWO = Shapes.or(box(3, 0, 6, 8, 3, 11), box(9, 0, 4, 13, 2.5, 8));
    private static final VoxelShape THREE = Shapes.or(TWO, box(7, 0, 9, 12, 2, 14));
    private static final VoxelShape FOUR = Shapes.or(THREE, box(5, 0, 2, 10, 2.5, 7));

    public PebbleBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(PEBBLES, 1).setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState state = ctx.getLevel().getBlockState(ctx.getClickedPos());
        if (state.is(this)) return state.setValue(PEBBLES, Math.min(4, state.getValue(PEBBLES) + 1));
        return this.defaultBlockState().setValue(FACING, Direction.from2DDataValue(ctx.getLevel().random.nextInt(4)));
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.isSecondaryUseActive() && context.getItemInHand().is(this.asItem()) && state.getValue(PEBBLES) < 4 || super.canBeReplaced(state, context);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(PEBBLES)) { case 2 -> TWO; case 3 -> THREE; case 4 -> FOUR; default -> ONE; };
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) { return state.setValue(FACING, rotation.rotate(state.getValue(FACING))); }
    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) { return state.rotate(mirror.getRotation(state.getValue(FACING))); }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) { builder.add(PEBBLES, FACING); }
}
