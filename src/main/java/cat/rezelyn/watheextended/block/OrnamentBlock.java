package cat.rezelyn.watheextended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

/**
 * Ornament block matching wathe's OrnamentBlock blockstate properties
 * (facing + shape), compatible with existing multipart model JSONs.
 */
public class OrnamentBlock extends Block {
    public static final DirectionProperty FACING = Properties.FACING;
    public static final EnumProperty<Shape> SHAPE = EnumProperty.of("shape", Shape.class);

    public enum Shape implements StringIdentifiable {
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
        @Override public String asString() { return id; }
    }

    public OrnamentBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, net.minecraft.util.math.Direction.NORTH)
                .with(SHAPE, Shape.ALL));
    }

    @Override
    protected MapCodec<? extends Block> getCodec() {
        return null;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE);
    }
}
