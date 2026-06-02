package cat.rezelyn.watheextended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class CabinetBlock extends HorizontalDirectionalBlock {
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public CabinetBlock(Properties s) { super(s); registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false)); }
    @Override protected MapCodec<? extends HorizontalDirectionalBlock> codec() { return null; }
    @Override public BlockState getStateForPlacement(BlockPlaceContext c) { return defaultBlockState().setValue(FACING, c.getHorizontalDirection().getOpposite()); }
    @Override protected InteractionResult useWithoutItem(BlockState s, Level w, BlockPos p, Player pl, BlockHitResult h) {
        if (!w.isClientSide) w.setBlock(p, s.cycle(OPEN), 3);
        return InteractionResult.SUCCESS;
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) { b.add(OPEN, FACING); }
}
