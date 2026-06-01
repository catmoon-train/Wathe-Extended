package cat.rezelyn.watheextended.index;

import cat.rezelyn.watheextended.WatheExtended;
import cat.rezelyn.watheextended.block.GreyiferPlushBlockEntity;
import cat.rezelyn.watheextended.block.IshPlushBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class WatheExtendedBlockEntities {

    public static final BlockEntityType<IshPlushBlockEntity> ISH_PLUSH = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            WatheExtended.id("ish_plush"),
            BlockEntityType.Builder.create(IshPlushBlockEntity::new, WatheExtendedBlocks.ISH_PLUSH).build()
    );

    public static final BlockEntityType<GreyiferPlushBlockEntity> GREYIFER_PLUSH = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            WatheExtended.id("greyifer_plush"),
            BlockEntityType.Builder.create(GreyiferPlushBlockEntity::new,
                    WatheExtendedBlocks.GREYIFER_PLUSH,
                    WatheExtendedBlocks.IWY_PLUSH).build(null)
    );

    public static void initialize() {}
}
