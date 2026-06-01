package cat.rezelyn.watheextended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

/**
 * Ornament block based on StarRailExpress's OrnamentBlock.
 * Players place ornaments on any face; clicking positions determines the shape.
 * Re-placing on the same block combines shapes.
 */
public class OrnamentBlock extends DirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final EnumProperty<Shape> SHAPE = EnumProperty.create("shape", Shape.class);

    // Thin panel shapes per direction (1 pixel thick for visual targeting)
    private static final VoxelShape SHAPE_DOWN  = box(0, 15, 0, 16, 16, 16);
    private static final VoxelShape SHAPE_UP    = box(0, 0, 0, 16, 1, 16);
    private static final VoxelShape SHAPE_NORTH = box(0, 0, 15, 16, 16, 16);
    private static final VoxelShape SHAPE_SOUTH = box(0, 0, 0, 16, 16, 1);
    private static final VoxelShape SHAPE_WEST  = box(15, 0, 0, 16, 16, 16);
    private static final VoxelShape SHAPE_EAST  = box(0, 0, 0, 1, 16, 16);

    public enum Shape implements StringRepresentable {
        ALL("all"), BOTTOM("bottom"), CENTER("center"),
        LEFT("left"), LEFT_BOTTOM("left_bottom"),
        LEFT_RIGHT("left_right"), LEFT_RIGHT_BOTTOM("left_right_bottom"),
        LEFT_RIGHT_CENTER("left_right_center"), LEFT_RIGHT_TOP("left_right_top"),
        LEFT_TOP("left_top"), LEFT_TOP_BOTTOM("left_top_bottom"),
        RIGHT("right"), RIGHT_BOTTOM("right_bottom"),
        RIGHT_TOP("right_top"), RIGHT_TOP_BOTTOM("right_top_bottom"),
        TOP("top"), TOP_BOTTOM("top_bottom");

        private final String id;
        Shape(String id) { this.id = id; }
        @Override public String getSerializedName() { return id; }
    }

    public OrnamentBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SHAPE, Shape.ALL));
    }

    @Override
    protected MapCodec<? extends DirectionalBlock> codec() {
        return null;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockPos pos = ctx.getClickedPos();
        Direction side = ctx.getClickedFace();
        Level world = ctx.getLevel();
        BlockState existing = world.getBlockState(pos);
        Vec2 hit = get2DHit(ctx.getClickLocation(), pos, side);
        boolean topRight = hit.x + hit.y > 1.0;
        boolean bottomRight = hit.x - hit.y > 0.0;

        Shape newShape = ctx.isSecondaryUseActive() ? Shape.CENTER
                : topRight && bottomRight ? Shape.RIGHT
                : topRight ? Shape.TOP
                : bottomRight ? Shape.RIGHT_BOTTOM
                : hit.x < 0.333 && hit.y < 0.333 ? Shape.LEFT
                : hit.x > 0.666 && hit.y < 0.333 ? Shape.RIGHT
                : hit.x < 0.333 && hit.y > 0.666 ? Shape.LEFT_TOP
                : hit.x > 0.666 && hit.y > 0.666 ? Shape.RIGHT_TOP
                : Shape.CENTER;

        if (existing.is(this)) {
            Shape existingShape = existing.getValue(SHAPE);
            Shape combined = existingShape == newShape ? existingShape
                    : tryCombine(existingShape, newShape);
            if (combined == existingShape) return null;
            return existing.setValue(FACING, side).setValue(SHAPE, combined);
        }

        return this.defaultBlockState().setValue(FACING, side).setValue(SHAPE, newShape);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return (context.getItemInHand().is(this.asItem()) && !context.isSecondaryUseActive())
                || super.canBeReplaced(state, context);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case DOWN  -> SHAPE_DOWN;
            case UP    -> SHAPE_UP;
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST  -> SHAPE_WEST;
            case EAST  -> SHAPE_EAST;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE);
    }

    // ---- helpers ----

    private Vec2 get2DHit(Vec3 clickLoc, BlockPos pos, Direction side) {
        double dx = clickLoc.x - pos.getX();
        double dy = clickLoc.y - pos.getY();
        double dz = clickLoc.z - pos.getZ();
        return switch (side) {
            case DOWN  -> new Vec2((float) dx, (float) dz);
            case UP    -> new Vec2((float) dx, (float) (1.0 - dz));
            case NORTH -> new Vec2((float) (1.0 - dx), (float) dy);
            case SOUTH -> new Vec2((float) dx, (float) dy);
            case WEST  -> new Vec2((float) dz, (float) dy);
            case EAST  -> new Vec2((float) (1.0 - dz), (float) dy);
        };
    }

    private Shape tryCombine(Shape a, Shape b) {
        if (a == Shape.ALL || b == Shape.ALL) return Shape.ALL;
        if (a == b) return a;

        // normalise to set
        int flags = shapeFlags(a) | shapeFlags(b);
        // try common combos
        if ((flags & (FLAG_LEFT | FLAG_RIGHT)) == (FLAG_LEFT | FLAG_RIGHT)) {
            if ((flags & (FLAG_TOP | FLAG_BOTTOM)) == (FLAG_TOP | FLAG_BOTTOM)) return Shape.ALL;
            if ((flags & FLAG_CENTER) != 0) return Shape.LEFT_RIGHT_CENTER;
            if ((flags & FLAG_TOP) != 0) return Shape.LEFT_RIGHT_TOP;
            if ((flags & FLAG_BOTTOM) != 0) return Shape.LEFT_RIGHT_BOTTOM;
            return Shape.LEFT_RIGHT;
        }
        if ((flags & (FLAG_TOP | FLAG_BOTTOM)) == (FLAG_TOP | FLAG_BOTTOM)) {
            if ((flags & FLAG_LEFT) != 0) return Shape.LEFT_TOP_BOTTOM;
            if ((flags & FLAG_RIGHT) != 0) return Shape.RIGHT_TOP_BOTTOM;
            return Shape.TOP_BOTTOM;
        }
        if ((flags & (FLAG_LEFT | FLAG_TOP)) == (FLAG_LEFT | FLAG_TOP)) return Shape.LEFT_TOP;
        if ((flags & (FLAG_LEFT | FLAG_BOTTOM)) == (FLAG_LEFT | FLAG_BOTTOM)) return Shape.LEFT_BOTTOM;
        if ((flags & (FLAG_RIGHT | FLAG_TOP)) == (FLAG_RIGHT | FLAG_TOP)) return Shape.RIGHT_TOP;
        if ((flags & (FLAG_RIGHT | FLAG_BOTTOM)) == (FLAG_RIGHT | FLAG_BOTTOM)) return Shape.RIGHT_BOTTOM;
        return a; // fallback
    }

    private static final int FLAG_LEFT = 1, FLAG_RIGHT = 2, FLAG_TOP = 4, FLAG_BOTTOM = 8, FLAG_CENTER = 16;

    private static int shapeFlags(Shape s) {
        return switch (s) {
            case LEFT -> FLAG_LEFT; case RIGHT -> FLAG_RIGHT;
            case TOP -> FLAG_TOP; case BOTTOM -> FLAG_BOTTOM; case CENTER -> FLAG_CENTER;
            case LEFT_RIGHT -> FLAG_LEFT | FLAG_RIGHT;
            case LEFT_TOP -> FLAG_LEFT | FLAG_TOP;
            case LEFT_BOTTOM -> FLAG_LEFT | FLAG_BOTTOM;
            case RIGHT_TOP -> FLAG_RIGHT | FLAG_TOP;
            case RIGHT_BOTTOM -> FLAG_RIGHT | FLAG_BOTTOM;
            case TOP_BOTTOM -> FLAG_TOP | FLAG_BOTTOM;
            case LEFT_RIGHT_TOP -> FLAG_LEFT | FLAG_RIGHT | FLAG_TOP;
            case LEFT_RIGHT_BOTTOM -> FLAG_LEFT | FLAG_RIGHT | FLAG_BOTTOM;
            case LEFT_RIGHT_CENTER -> FLAG_LEFT | FLAG_RIGHT | FLAG_CENTER;
            case LEFT_TOP_BOTTOM -> FLAG_LEFT | FLAG_TOP | FLAG_BOTTOM;
            case RIGHT_TOP_BOTTOM -> FLAG_RIGHT | FLAG_TOP | FLAG_BOTTOM;
            default -> 0; // ALL
        };
    }
}
