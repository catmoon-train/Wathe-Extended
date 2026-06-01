package cat.rezelyn.watheextended;

import cat.rezelyn.watheextended.index.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WatheExtended implements ModInitializer {
    public static final String MOD_ID = "watheextended";
    private static final Logger LOGGER = LoggerFactory.getLogger(WatheExtended.class);

    public static @NotNull ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    @Override
    public void onInitialize() {
        WatheExtendedSounds.initialize();
        WatheExtendedItems.initialize();
        WatheExtendedBlocks.initialize();
        WatheExtendedBlockEntities.initialize();
        WatheExtendedGroup.initialize();

        LOGGER.info("Wathe Extended initialized!");
    }
}
