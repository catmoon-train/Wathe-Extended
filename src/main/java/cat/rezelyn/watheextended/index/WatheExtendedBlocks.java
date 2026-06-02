package cat.rezelyn.watheextended.index;

import cat.rezelyn.watheextended.WatheExtended;
import cat.rezelyn.watheextended.block.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class WatheExtendedBlocks {
    // Panels
    public static final Block TARNISHED_GOLD_PANEL = register("tarnished_gold_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.NETHERITE_BLOCK)));
    public static final Block GOLD_PANEL = register("gold_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.NETHERITE_BLOCK)));
    public static final Block PRISTINE_GOLD_PANEL = register("pristine_gold_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.NETHERITE_BLOCK)));
    public static final Block BLACK_HULL_PANEL = register("black_hull_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.NETHERITE_BLOCK)));
    public static final Block BLACK_HULL_SHEETS_PANEL = register("black_hull_sheets_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.COPPER)));
    public static final Block METAL_SHEET_PANEL = register("metal_sheet_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.COPPER)));
    public static final Block STAINLESS_STEEL_PANEL = register("stainless_steel_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.COPPER)));
    public static final Block DARK_STEEL_PANEL = register("dark_steel_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.COPPER)));
    public static final Block MARBLE_PANEL = register("marble_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.CALCITE)));
    public static final Block DARK_MARBLE_PANEL = register("dark_marble_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.CALCITE)));
    public static final Block MARBLE_TILES_PANEL = register("marble_tiles_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.CALCITE)));
    public static final Block MAHOGANY_PLANKS_PANEL = register("mahogany_planks_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block MAHOGANY_HERRINGBONE_PANEL = register("mahogany_herringbone_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block MAHOGANY_BOOKSHELF_PANEL = register("mahogany_bookshelf_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block BUBINGA_PLANKS_PANEL = register("bubinga_planks_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block BUBINGA_HERRINGBONE_PANEL = register("bubinga_herringbone_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block BUBINGA_BOOKSHELF_PANEL = register("bubinga_bookshelf_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block EBONY_PLANKS_PANEL = register("ebony_planks_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block EBONY_HERRINGBONE_PANEL = register("ebony_herringbone_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block EBONY_BOOKSHELF_PANEL = register("ebony_bookshelf_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));

    // Ornaments
    public static final Block ANTHRACITE_STEEL_ORNAMENT = register("anthracite_steel_ornament", new OrnamentBlock(ornamentBlock()));
    public static final Block KHAKI_STEEL_ORNAMENT = register("khaki_steel_ornament", new OrnamentBlock(ornamentBlock()));
    public static final Block MAROON_STEEL_ORNAMENT = register("maroon_steel_ornament", new OrnamentBlock(ornamentBlock()));
    public static final Block MUNTZ_STEEL_ORNAMENT = register("muntz_steel_ornament", new OrnamentBlock(ornamentBlock()));
    public static final Block NAVY_STEEL_ORNAMENT = register("navy_steel_ornament", new OrnamentBlock(ornamentBlock()));

    // Moquettes
    public static final Block WHITE_MOQUETTE = register("white_moquette", new Block(moquetteBlock()));
    public static final Block LIGHT_GRAY_MOQUETTE = register("light_gray_moquette", new Block(moquetteBlock()));
    public static final Block GRAY_MOQUETTE = register("gray_moquette", new Block(moquetteBlock()));
    public static final Block BLACK_MOQUETTE = register("black_moquette", new Block(moquetteBlock()));
    public static final Block ORANGE_MOQUETTE = register("orange_moquette", new Block(moquetteBlock()));
    public static final Block YELLOW_MOQUETTE = register("yellow_moquette", new Block(moquetteBlock()));
    public static final Block LIME_MOQUETTE = register("lime_moquette", new Block(moquetteBlock()));
    public static final Block GREEN_MOQUETTE = register("green_moquette", new Block(moquetteBlock()));
    public static final Block CYAN_MOQUETTE = register("cyan_moquette", new Block(moquetteBlock()));
    public static final Block LIGHT_BLUE_MOQUETTE = register("light_blue_moquette", new Block(moquetteBlock()));
    public static final Block PURPLE_MOQUETTE = register("purple_moquette", new Block(moquetteBlock()));
    public static final Block MAGENTA_MOQUETTE = register("magenta_moquette", new Block(moquetteBlock()));
    public static final Block PINK_MOQUETTE = register("pink_moquette", new Block(moquetteBlock()));

    // Snowy Leaves
    public static final Block SNOWY_OAK_LEAVES = register("snowy_oak_leaves", new LeavesBlock(leavesBlock()));
    public static final Block SNOWY_SPRUCE_LEAVES = register("snowy_spruce_leaves", new LeavesBlock(leavesBlock()));
    public static final Block SNOWY_BIRCH_LEAVES = register("snowy_birch_leaves", new LeavesBlock(leavesBlock()));
    public static final Block SNOWY_JUNGLE_LEAVES = register("snowy_jungle_leaves", new LeavesBlock(leavesBlock()));
    public static final Block SNOWY_ACACIA_LEAVES = register("snowy_acacia_leaves", new LeavesBlock(leavesBlock()));
    public static final Block SNOWY_DARK_OAK_LEAVES = register("snowy_dark_oak_leaves", new LeavesBlock(leavesBlock()));
    public static final Block SNOWY_MANGROVE_LEAVES = register("snowy_mangrove_leaves", new LeavesBlock(leavesBlock()));
    public static final Block SNOWY_CHERRY_LEAVES = register("snowy_cherry_leaves", new LeavesBlock(leavesBlock()));
    public static final Block SNOWY_AZALEA_LEAVES = register("snowy_azalea_leaves", new LeavesBlock(leavesBlock()));
    public static final Block SNOWY_FLOWERING_AZALEA_LEAVES = register("snowy_flowering_azalea_leaves", new LeavesBlock(leavesBlock()));

    // Plushies
    public static final Block ISH_PLUSH = register("ish_plush", new IshPlushBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOL)));

    // gexpress decorative blocks
    public static final Block SAND_LAYER = register("sand_layer", new SandLayerBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.SAND).replaceable().strength(0.5f).sound(SoundType.SAND).pushReaction(PushReaction.DESTROY)));
    public static final Block RED_SAND_LAYER = register("red_sand_layer", new SandLayerBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_ORANGE).replaceable().strength(0.5f).sound(SoundType.SAND).pushReaction(PushReaction.DESTROY)));
    public static final Block GREYIFER_PLUSH = register("greyifer_plush", new GreyiferPlushBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK).strength(0.5f).sound(SoundType.WOOL).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block IWY_PLUSH = register("iwy_plush", new GreyiferPlushBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.SNOW).strength(0.5f).sound(SoundType.WOOL).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block FAKE_SUSPICIOUS_SAND = register("fake_suspicious_sand", new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.SAND).strength(0.25f).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY)));
    public static final Block FAKE_SUSPICIOUS_GRAVEL = register("fake_suspicious_gravel", new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(0.25f).sound(SoundType.SUSPICIOUS_GRAVEL).pushReaction(PushReaction.DESTROY)));
    public static final Block PEBBLE_BLOCK = register("pebble_block", new PebbleBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(0.5f).sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));

    // Pizza & Music Disc Box
    public static final Block PIZZA = register("pizza", new PizzaBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.MUD)));
    public static final Block MUSIC_DISC_BOX = register("music_disc_box", new MusicDiscBoxBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOD)));

    // SRE decorative blocks
    public static final Block GOLD_LEDGE = register("gold_ledge", new LedgeBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.METAL)));
    public static final Block ANTHRACITE_LEDGE = register("anthracite_ledge", new LedgeBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.METAL)));
    public static final Block KHAKI_LEDGE = register("khaki_ledge", new LedgeBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.METAL)));
    public static final Block MAROON_LEDGE = register("maroon_ledge", new LedgeBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.METAL)));
    public static final Block MUNTZ_LEDGE = register("muntz_ledge", new LedgeBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.METAL)));
    public static final Block NAVY_LEDGE = register("navy_ledge", new LedgeBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.METAL)));
    public static final Block ACACIA_CABINET = register("acacia_cabinet", new CabinetBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block BIRCH_CABINET = register("birch_cabinet", new CabinetBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block CHERRY_CABINET = register("cherry_cabinet", new CabinetBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block DARK_OAK_CABINET = register("dark_oak_cabinet", new CabinetBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block JUNGLE_CABINET = register("jungle_cabinet", new CabinetBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block MANGROVE_CABINET = register("mangrove_cabinet", new CabinetBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block OAK_CABINET = register("oak_cabinet", new CabinetBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block SPRUCE_CABINET = register("spruce_cabinet", new CabinetBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block GOLD_FOOD_PLATTER = register("gold_food_platter", new FoodPlatterBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.METAL)));
    public static final Block GOLD_DRINK_TRAY = register("gold_drink_tray", new DrinkTrayBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.METAL)));

    // Building blocks - Ash
    public static final Block ASH_PLANKS = register("ash_planks", new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block ASH_PLANKS_STAIRS = register("ash_planks_stairs", new StairBlock(ASH_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS)));
    public static final Block ASH_PLANKS_SLAB = register("ash_planks_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS)));
    public static final Block ASH_PLANKS_PANEL = register("ash_planks_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block SMOOTH_ASH = register("smooth_ash", new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block SMOOTH_ASH_STAIRS = register("smooth_ash_stairs", new StairBlock(SMOOTH_ASH.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMOOTH_ASH)));
    public static final Block SMOOTH_ASH_SLAB = register("smooth_ash_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMOOTH_ASH)));
    public static final Block SMOOTH_ASH_PANEL = register("smooth_ash_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block ASH_HERRINGBONE = register("ash_herringbone", new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block ASH_HERRINGBONE_STAIRS = register("ash_herringbone_stairs", new StairBlock(ASH_HERRINGBONE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ASH_HERRINGBONE)));
    public static final Block ASH_HERRINGBONE_SLAB = register("ash_herringbone_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ASH_HERRINGBONE)));
    public static final Block ASH_HERRINGBONE_PANEL = register("ash_herringbone_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));

    // Building blocks - Olive
    public static final Block OLIVE_PLANKS = register("olive_planks", new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block OLIVE_PLANKS_STAIRS = register("olive_planks_stairs", new StairBlock(OLIVE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(OLIVE_PLANKS)));
    public static final Block OLIVE_PLANKS_SLAB = register("olive_planks_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(OLIVE_PLANKS)));
    public static final Block OLIVE_PLANKS_PANEL = register("olive_planks_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block SMOOTH_OLIVE = register("smooth_olive", new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block SMOOTH_OLIVE_STAIRS = register("smooth_olive_stairs", new StairBlock(SMOOTH_OLIVE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMOOTH_OLIVE)));
    public static final Block SMOOTH_OLIVE_SLAB = register("smooth_olive_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMOOTH_OLIVE)));
    public static final Block SMOOTH_OLIVE_PANEL = register("smooth_olive_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block OLIVE_HERRINGBONE = register("olive_herringbone", new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block OLIVE_HERRINGBONE_STAIRS = register("olive_herringbone_stairs", new StairBlock(OLIVE_HERRINGBONE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(OLIVE_HERRINGBONE)));
    public static final Block OLIVE_HERRINGBONE_SLAB = register("olive_herringbone_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(OLIVE_HERRINGBONE)));
    public static final Block OLIVE_HERRINGBONE_PANEL = register("olive_herringbone_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));

    // Building blocks - Plum
    public static final Block PLUM_PLANKS = register("plum_planks", new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block PLUM_PLANKS_STAIRS = register("plum_planks_stairs", new StairBlock(PLUM_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PLUM_PLANKS)));
    public static final Block PLUM_PLANKS_SLAB = register("plum_planks_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PLUM_PLANKS)));
    public static final Block PLUM_PLANKS_PANEL = register("plum_planks_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block SMOOTH_PLUM = register("smooth_plum", new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block SMOOTH_PLUM_STAIRS = register("smooth_plum_stairs", new StairBlock(SMOOTH_PLUM.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMOOTH_PLUM)));
    public static final Block SMOOTH_PLUM_SLAB = register("smooth_plum_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMOOTH_PLUM)));
    public static final Block SMOOTH_PLUM_PANEL = register("smooth_plum_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));
    public static final Block PLUM_HERRINGBONE = register("plum_herringbone", new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOD)));
    public static final Block PLUM_HERRINGBONE_STAIRS = register("plum_herringbone_stairs", new StairBlock(PLUM_HERRINGBONE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PLUM_HERRINGBONE)));
    public static final Block PLUM_HERRINGBONE_SLAB = register("plum_herringbone_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PLUM_HERRINGBONE)));
    public static final Block PLUM_HERRINGBONE_PANEL = register("plum_herringbone_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOD)));

    // Moquette variants
    public static final Block BLACK_MOQUETTE_PANEL = register("black_moquette_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOL)));
    public static final Block BLACK_MOQUETTE_SLAB = register("black_moquette_slab", new SlabBlock(moquetteBlock()));
    public static final Block BLACK_MOQUETTE_STAIRS = register("black_moquette_stairs", new StairBlock(BLACK_MOQUETTE.defaultBlockState(), moquetteBlock()));
    public static final Block BLUE_MOQUETTE_PANEL = register("blue_moquette_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOL)));
    public static final Block BLUE_MOQUETTE_SLAB = register("blue_moquette_slab", new SlabBlock(moquetteBlock()));
    public static final Block BLUE_MOQUETTE_STAIRS = register("blue_moquette_stairs", new StairBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).defaultBlockState(), moquetteBlock()));
    public static final Block BROWN_MOQUETTE_PANEL = register("brown_moquette_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOL)));
    public static final Block BROWN_MOQUETTE_SLAB = register("brown_moquette_slab", new SlabBlock(moquetteBlock()));
    public static final Block BROWN_MOQUETTE_STAIRS = register("brown_moquette_stairs", new StairBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).defaultBlockState(), moquetteBlock()));
    public static final Block GREEN_MOQUETTE_PANEL = register("green_moquette_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOL)));
    public static final Block GREEN_MOQUETTE_SLAB = register("green_moquette_slab", new SlabBlock(moquetteBlock()));
    public static final Block GREEN_MOQUETTE_STAIRS = register("green_moquette_stairs", new StairBlock(GREEN_MOQUETTE.defaultBlockState(), moquetteBlock()));
    public static final Block PURPLE_MOQUETTE_PANEL = register("purple_moquette_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOL)));
    public static final Block PURPLE_MOQUETTE_SLAB = register("purple_moquette_slab", new SlabBlock(moquetteBlock()));
    public static final Block PURPLE_MOQUETTE_STAIRS = register("purple_moquette_stairs", new StairBlock(PURPLE_MOQUETTE.defaultBlockState(), moquetteBlock()));
    public static final Block RED_MOQUETTE_PANEL = register("red_moquette_panel", new PanelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.2f).sound(SoundType.WOOL)));
    public static final Block RED_MOQUETTE_SLAB = register("red_moquette_slab", new SlabBlock(moquetteBlock()));
    public static final Block RED_MOQUETTE_STAIRS = register("red_moquette_stairs", new StairBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).defaultBlockState(), moquetteBlock()));

    // Additional Plushies
    public static final Block LUX_PLUSH = register("lux_plush", new GreyiferPlushBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block PIZZA_PLUSH = register("pizza_plush", new GreyiferPlushBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block WTFJIMJIM_PLUSH = register("wtfjimjim_plush", new GreyiferPlushBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));

    private static BlockBehaviour.Properties ornamentBlock() {
        return BlockBehaviour.Properties.of().noOcclusion().noCollission().strength(0.25f).sound(SoundType.COPPER);
    }
    private static BlockBehaviour.Properties moquetteBlock() {
        return BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL);
    }
    private static BlockBehaviour.Properties leavesBlock() {
        return BlockBehaviour.Properties.of().noOcclusion().randomTicks().strength(0.2f).sound(SoundType.GRASS);
    }

    private static <T extends Block> T register(String id, T block) {
        Registry.register(BuiltInRegistries.BLOCK, WatheExtended.id(id), block);
        Registry.register(BuiltInRegistries.ITEM, WatheExtended.id(id), new BlockItem(block, new Item.Properties()));
        return block;
    }

    public static void initialize() {}
}
