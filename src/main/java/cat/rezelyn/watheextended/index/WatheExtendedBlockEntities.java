package cat.rezelyn.watheextended.index;

import cat.rezelyn.watheextended.WatheExtended;
import cat.rezelyn.watheextended.block.GreyiferPlushBlockEntity;
import cat.rezelyn.watheextended.block.IshPlushBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class WatheExtendedBlockEntities {
    public static final BlockEntityType<IshPlushBlockEntity> ISH_PLUSH = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE, WatheExtended.id("ish_plush"),
            BlockEntityType.Builder.of(IshPlushBlockEntity::new, WatheExtendedBlocks.ISH_PLUSH).build(null));
    public static final BlockEntityType<GreyiferPlushBlockEntity> GREYIFER_PLUSH = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE, WatheExtended.id("greyifer_plush"),
            BlockEntityType.Builder.of(GreyiferPlushBlockEntity::new,
                    WatheExtendedBlocks.GREYIFER_PLUSH, WatheExtendedBlocks.IWY_PLUSH).build(null));
    public static void initialize() {}
}
