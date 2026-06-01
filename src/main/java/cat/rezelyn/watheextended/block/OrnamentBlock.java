package cat.rezelyn.watheextended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Ornament block compatible with existing multipart model JSONs
 * (facing + shape properties).
 */
public class OrnamentBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final EnumProperty<Shape> SHAPE = EnumProperty.create("shape", Shape.class);

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
    protected MapCodec<? extends Block> codec() {
        return null;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE);
    }
}
