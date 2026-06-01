package cat.rezelyn.watheextended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.MultifaceBlock;
import net.minecraft.block.MultifaceSpreader;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Arrays;

/**
 * Panel block based on StarRailExpress's PanelBlock
 * (io.wifi.starrailexpress.content.block.PanelBlock).
 */
public class PanelBlock extends MultifaceBlock {

    public PanelBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends MultifaceBlock> getCodec() {
        return null;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return true;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return state;
    }

    @Override
    public boolean isValidStateForPlacement(BlockView world, BlockState state, BlockPos pos, Direction direction) {
        return this.isFaceSupported(direction) && (!state.isOf(this) || !hasFace(state, direction));
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return context.getStack().isOf(this.asItem())
                && Arrays.stream(DIRECTIONS).anyMatch(direction -> !hasFace(state, direction))
                && !context.shouldCancelInteraction();
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }
}
