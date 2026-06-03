package cat.rezelyn.watheextended.block;

import org.jetbrains.annotations.Nullable;

import com.mojang.serialization.MapCodec;

import io.wifi.starrailexpress.content.block.PlatterBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WatheExtendedFoodPlatterBlock extends PlatterBlock {
    public static final MapCodec<WatheExtendedFoodPlatterBlock> CODEC = createSimpleCodec(
            WatheExtendedFoodPlatterBlock::new);

    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public WatheExtendedFoodPlatterBlock(Properties settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity newPlateBlockEntity(BlockPos pos, BlockState state) {
        WatheExtendedBeveragePlateBlockEntity plate = new WatheExtendedBeveragePlateBlockEntity(pos, state);
        plate.setDrink(false);
        return plate;
    }
}
