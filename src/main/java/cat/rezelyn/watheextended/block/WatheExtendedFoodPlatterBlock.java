package cat.rezelyn.watheextended.block;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import cat.rezelyn.watheextended.index.WatheExtendedBlockEntities;
import io.wifi.starrailexpress.content.block.FoodPlatterBlock;
import io.wifi.starrailexpress.content.block_entity.BeveragePlateBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class WatheExtendedFoodPlatterBlock extends FoodPlatterBlock {

    public WatheExtendedFoodPlatterBlock(Properties settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        BeveragePlateBlockEntity plate = new WatheExtendedBeveragePlateBlockEntity(pos, state);
        plate.setDrink(false);
        return plate;
    }

    @Override
    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(@NotNull Level world, BlockState state,
            BlockEntityType<T> type) {
        return world.isClientSide && type.equals(WatheExtendedBlockEntities.BEVERAGE_PLATE)
                ? BeveragePlateBlockEntity::clientTick
                : null;
    }
}
