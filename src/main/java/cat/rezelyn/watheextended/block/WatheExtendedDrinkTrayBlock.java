package cat.rezelyn.watheextended.block;

import org.jetbrains.annotations.Nullable;

import io.wifi.starrailexpress.content.block.DrinkTrayBlock;
import io.wifi.starrailexpress.content.block_entity.BeveragePlateBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WatheExtendedDrinkTrayBlock extends DrinkTrayBlock {

    public WatheExtendedDrinkTrayBlock(Properties settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        BeveragePlateBlockEntity plate = new WatheExtendedBeveragePlateBlockEntity(pos, state);
        plate.setDrink(true);
        return plate;
    }
}
