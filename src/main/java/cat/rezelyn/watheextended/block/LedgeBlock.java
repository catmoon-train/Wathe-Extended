package cat.rezelyn.watheextended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LedgeBlock extends Block {

    public static final MapCodec<LedgeBlock> CODEC = simpleCodec(LedgeBlock::new);

    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty UP = BooleanProperty.create("up");

    private static final Direction[] HORIZONTALS = { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST };

    // Outline shapes — 2 pixels thick
    private static final VoxelShape NORTH_OUTLINE = box(0, 0, 0, 16, 2, 2);
    private static final VoxelShape EAST_OUTLINE = box(14, 0, 0, 16, 2, 16);
    private static final VoxelShape SOUTH_OUTLINE = box(0, 0, 14, 16, 2, 16);
    private static final VoxelShape WEST_OUTLINE = box(0, 0, 0, 2, 2, 16);
    private static final VoxelShape NORTH_TOP_OUTLINE = box(0, 14, 0, 16, 16, 2);
    private static final VoxelShape EAST_TOP_OUTLINE = box(14, 14, 0, 16, 16, 16);
    private static final VoxelShape SOUTH_TOP_OUTLINE = box(0, 14, 14, 16, 16, 16);
    private static final VoxelShape WEST_TOP_OUTLINE = box(0, 14, 0, 2, 16, 16);

    // Collision shapes — 8 pixels thick
    private static final VoxelShape NORTH_COLLISION = box(0, 0, 0, 16, 8, 8);
    private static final VoxelShape EAST_COLLISION = box(8, 0, 0, 16, 8, 16);
    private static final VoxelShape SOUTH_COLLISION = box(0, 0, 8, 16, 8, 16);
    private static final VoxelShape WEST_COLLISION = box(0, 0, 0, 8, 8, 16);
    private static final VoxelShape NORTH_TOP_COLLISION = box(0, 8, 0, 16, 16, 8);
    private static final VoxelShape EAST_TOP_COLLISION = box(8, 8, 0, 16, 16, 16);
    private static final VoxelShape SOUTH_TOP_COLLISION = box(0, 8, 8, 16, 16, 16);
    private static final VoxelShape WEST_TOP_COLLISION = box(0, 8, 0, 8, 16, 16);

    public LedgeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, true)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(UP, false));
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState existing = context.getLevel().getBlockState(context.getClickedPos());
        Direction direction = context.getClickedFace();
        boolean top = isTopPlacement(context);

        if (existing.is(this)) {
            if (existing.getValue(UP) != top) return null;
            if (!existing.getValue(property(direction))) {
                return existing.setValue(property(direction), true);
            }
            for (Direction horizontal : HORIZONTALS) {
                if (!existing.getValue(property(horizontal))) {
                    return existing.setValue(property(horizontal), true);
                }
            }
            return existing;
        }

        return this.defaultBlockState()
                .setValue(NORTH, false)
                .setValue(UP, top)
                .setValue(property(direction), true);
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        if (!context.getItemInHand().is(this.asItem()) || context.isSecondaryUseActive()) return false;
        if (state.getValue(UP) != isTopPlacement(context)) return false;
        for (Direction direction : HORIZONTALS) {
            if (!state.getValue(property(direction))) return true;
        }
        return false;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return combinedShape(state, false);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return combinedShape(state, true);
    }

    private static VoxelShape combinedShape(BlockState state, boolean collision) {
        VoxelShape shape = Shapes.empty();
        boolean top = state.getValue(UP);
        if (state.getValue(NORTH)) shape = Shapes.join(shape, shapeFor(Direction.NORTH, top, collision), BooleanOp.OR);
        if (state.getValue(EAST)) shape = Shapes.join(shape, shapeFor(Direction.EAST, top, collision), BooleanOp.OR);
        if (state.getValue(SOUTH)) shape = Shapes.join(shape, shapeFor(Direction.SOUTH, top, collision), BooleanOp.OR);
        if (state.getValue(WEST)) shape = Shapes.join(shape, shapeFor(Direction.WEST, top, collision), BooleanOp.OR);
        return shape;
    }

    private static VoxelShape shapeFor(Direction direction, boolean top, boolean collision) {
        return switch (direction) {
            case EAST -> top ? (collision ? EAST_TOP_COLLISION : EAST_TOP_OUTLINE)
                    : (collision ? EAST_COLLISION : EAST_OUTLINE);
            case SOUTH -> top ? (collision ? SOUTH_TOP_COLLISION : SOUTH_TOP_OUTLINE)
                    : (collision ? SOUTH_COLLISION : SOUTH_OUTLINE);
            case WEST -> top ? (collision ? WEST_TOP_COLLISION : WEST_TOP_OUTLINE)
                    : (collision ? WEST_COLLISION : WEST_OUTLINE);
            default -> top ? (collision ? NORTH_TOP_COLLISION : NORTH_TOP_OUTLINE)
                    : (collision ? NORTH_COLLISION : NORTH_OUTLINE);
        };
    }

    private static boolean isTopPlacement(BlockPlaceContext context) {
        if (context.getClickedFace() == Direction.DOWN) return false;
        double localY = context.getClickLocation().y - context.getClickedPos().getY();
        return localY > 0.5;
    }

    private static BooleanProperty property(Direction direction) {
        return switch (direction) {
            case EAST -> EAST;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            default -> NORTH;
        };
    }
}
