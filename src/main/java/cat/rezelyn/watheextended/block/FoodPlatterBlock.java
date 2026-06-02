package cat.rezelyn.watheextended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FoodPlatterBlock extends Block {
    public static final MapCodec<FoodPlatterBlock> CODEC = simpleCodec(FoodPlatterBlock::new);
    private static final VoxelShape SHAPE = box(0, 0, 0, 16, 2, 16);
    public FoodPlatterBlock(Properties s) { super(s); }
    @Override protected MapCodec<? extends Block> codec() { return CODEC; }
    @Override protected VoxelShape getShape(BlockState s, BlockGetter w, BlockPos p, CollisionContext c) { return SHAPE; }
}
