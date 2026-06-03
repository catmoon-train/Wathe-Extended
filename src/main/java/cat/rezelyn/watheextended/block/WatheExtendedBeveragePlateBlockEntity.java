package cat.rezelyn.watheextended.block;

import cat.rezelyn.watheextended.index.WatheExtendedBlockEntities;
import io.wifi.starrailexpress.content.block_entity.PlateTrayBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class WatheExtendedBeveragePlateBlockEntity extends PlateTrayBlockEntity {
    public String Hello = "World";

    protected WatheExtendedBeveragePlateBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public WatheExtendedBeveragePlateBlockEntity(BlockPos pos, BlockState state) {
        this(WatheExtendedBlockEntities.BEVERAGE_PLATE, pos, state);
    }
}
