package cat.rezelyn.watheextended.index;

import cat.rezelyn.watheextended.WatheExtended;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class WatheExtendedGroup {
    public static final ResourceKey<CreativeModeTab> WATHE_EXTENDED_GROUP =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, WatheExtended.id("main"));

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, WATHE_EXTENDED_GROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(WatheExtendedItems.GUIDEBOOK))
                .title(Component.translatable("itemGroup.watheextended.main"))
                .displayItems((context, entries) -> {
                    entries.accept(WatheExtendedBlocks.TARNISHED_GOLD_PANEL);
                    entries.accept(WatheExtendedBlocks.GOLD_PANEL);
                    entries.accept(WatheExtendedBlocks.PRISTINE_GOLD_PANEL);
                    entries.accept(WatheExtendedBlocks.BLACK_HULL_PANEL);
                    entries.accept(WatheExtendedBlocks.BLACK_HULL_SHEETS_PANEL);
                    entries.accept(WatheExtendedBlocks.METAL_SHEET_PANEL);
                    entries.accept(WatheExtendedBlocks.STAINLESS_STEEL_PANEL);
                    entries.accept(WatheExtendedBlocks.DARK_STEEL_PANEL);
                    entries.accept(WatheExtendedBlocks.MARBLE_PANEL);
                    entries.accept(WatheExtendedBlocks.DARK_MARBLE_PANEL);
                    entries.accept(WatheExtendedBlocks.MARBLE_TILES_PANEL);
                    entries.accept(WatheExtendedBlocks.MAHOGANY_PLANKS_PANEL);
                    entries.accept(WatheExtendedBlocks.MAHOGANY_HERRINGBONE_PANEL);
                    entries.accept(WatheExtendedBlocks.MAHOGANY_BOOKSHELF_PANEL);
                    entries.accept(WatheExtendedBlocks.BUBINGA_PLANKS_PANEL);
                    entries.accept(WatheExtendedBlocks.BUBINGA_HERRINGBONE_PANEL);
                    entries.accept(WatheExtendedBlocks.BUBINGA_BOOKSHELF_PANEL);
                    entries.accept(WatheExtendedBlocks.EBONY_PLANKS_PANEL);
                    entries.accept(WatheExtendedBlocks.EBONY_HERRINGBONE_PANEL);
                    entries.accept(WatheExtendedBlocks.EBONY_BOOKSHELF_PANEL);

                    entries.accept(WatheExtendedBlocks.ANTHRACITE_STEEL_ORNAMENT);
                    entries.accept(WatheExtendedBlocks.KHAKI_STEEL_ORNAMENT);
                    entries.accept(WatheExtendedBlocks.MAROON_STEEL_ORNAMENT);
                    entries.accept(WatheExtendedBlocks.MUNTZ_STEEL_ORNAMENT);
                    entries.accept(WatheExtendedBlocks.NAVY_STEEL_ORNAMENT);

                    entries.accept(WatheExtendedBlocks.WHITE_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.LIGHT_GRAY_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.GRAY_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.BLACK_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.ORANGE_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.YELLOW_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.LIME_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.GREEN_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.CYAN_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.LIGHT_BLUE_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.PURPLE_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.MAGENTA_MOQUETTE);
                    entries.accept(WatheExtendedBlocks.PINK_MOQUETTE);

                    entries.accept(WatheExtendedBlocks.SNOWY_OAK_LEAVES);
                    entries.accept(WatheExtendedBlocks.SNOWY_SPRUCE_LEAVES);
                    entries.accept(WatheExtendedBlocks.SNOWY_BIRCH_LEAVES);
                    entries.accept(WatheExtendedBlocks.SNOWY_JUNGLE_LEAVES);
                    entries.accept(WatheExtendedBlocks.SNOWY_ACACIA_LEAVES);
                    entries.accept(WatheExtendedBlocks.SNOWY_DARK_OAK_LEAVES);
                    entries.accept(WatheExtendedBlocks.SNOWY_MANGROVE_LEAVES);
                    entries.accept(WatheExtendedBlocks.SNOWY_CHERRY_LEAVES);
                    entries.accept(WatheExtendedBlocks.SNOWY_AZALEA_LEAVES);
                    entries.accept(WatheExtendedBlocks.SNOWY_FLOWERING_AZALEA_LEAVES);

                    entries.accept(WatheExtendedBlocks.ISH_PLUSH);
                    entries.accept(WatheExtendedBlocks.GREYIFER_PLUSH);
                    entries.accept(WatheExtendedBlocks.IWY_PLUSH);
                    entries.accept(WatheExtendedBlocks.SAND_LAYER);
                    entries.accept(WatheExtendedBlocks.RED_SAND_LAYER);
                    entries.accept(WatheExtendedBlocks.PEBBLE_BLOCK);
                    entries.accept(WatheExtendedBlocks.FAKE_SUSPICIOUS_SAND);
                    entries.accept(WatheExtendedBlocks.FAKE_SUSPICIOUS_GRAVEL);
                    entries.accept(WatheExtendedBlocks.PIZZA);
                    entries.accept(WatheExtendedBlocks.MUSIC_DISC_BOX);

                    // SRE decorative blocks
                    entries.accept(WatheExtendedBlocks.GOLD_LEDGE);
                    entries.accept(WatheExtendedBlocks.ANTHRACITE_LEDGE);
                    entries.accept(WatheExtendedBlocks.KHAKI_LEDGE);
                    entries.accept(WatheExtendedBlocks.MAROON_LEDGE);
                    entries.accept(WatheExtendedBlocks.MUNTZ_LEDGE);
                    entries.accept(WatheExtendedBlocks.NAVY_LEDGE);
                    entries.accept(WatheExtendedBlocks.MAHOGANY_CABINET);
                    entries.accept(WatheExtendedBlocks.BUBINGA_CABINET);
                    entries.accept(WatheExtendedBlocks.EBONY_CABINET);
                    entries.accept(WatheExtendedBlocks.ACACIA_CABINET);
                    entries.accept(WatheExtendedBlocks.BIRCH_CABINET);
                    entries.accept(WatheExtendedBlocks.CHERRY_CABINET);
                    entries.accept(WatheExtendedBlocks.DARK_OAK_CABINET);
                    entries.accept(WatheExtendedBlocks.JUNGLE_CABINET);
                    entries.accept(WatheExtendedBlocks.MANGROVE_CABINET);
                    entries.accept(WatheExtendedBlocks.OAK_CABINET);
                    entries.accept(WatheExtendedBlocks.SPRUCE_CABINET);
                    entries.accept(WatheExtendedBlocks.GOLD_FOOD_PLATTER);
                    entries.accept(WatheExtendedBlocks.GOLD_DRINK_TRAY);

                    entries.accept(WatheExtendedItems.COTTON_CANDY_SHAKE);
                    entries.accept(WatheExtendedItems.GALAXY_FIZZ);
                    entries.accept(WatheExtendedItems.HONEY_LEMONADE);
                    entries.accept(WatheExtendedItems.MINT_OCEAN);
                    entries.accept(WatheExtendedItems.NEON_SPLASH);
                    entries.accept(WatheExtendedItems.PRIDE_PUNCH);
                    entries.accept(WatheExtendedItems.SUNSET_PRISM);
                    entries.accept(WatheExtendedItems.THE_AMETHYST);
                    entries.accept(WatheExtendedItems.VELVET_ACE);
                    entries.accept(WatheExtendedItems.GUIDEBOOK);
                })
                .build());
    }
}
