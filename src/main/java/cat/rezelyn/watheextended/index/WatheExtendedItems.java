package cat.rezelyn.watheextended.index;

import cat.rezelyn.watheextended.WatheExtended;
import cat.rezelyn.watheextended.item.CocktailItem;
import cat.rezelyn.watheextended.item.GuidebookItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class WatheExtendedItems {
    public static final Item GUIDEBOOK = register("guidebook", new GuidebookItem(new Item.Properties().stacksTo(1)));
    public static final Item COTTON_CANDY_SHAKE = register("cotton_candy_shake", new CocktailItem(new Item.Properties().stacksTo(16)));
    public static final Item GALAXY_FIZZ       = register("galaxy_fizz",       new CocktailItem(new Item.Properties().stacksTo(16)));
    public static final Item HONEY_LEMONADE    = register("honey_lemonade",    new CocktailItem(new Item.Properties().stacksTo(16)));
    public static final Item MINT_OCEAN        = register("mint_ocean",        new CocktailItem(new Item.Properties().stacksTo(16)));
    public static final Item NEON_SPLASH       = register("neon_splash",       new CocktailItem(new Item.Properties().stacksTo(16)));
    public static final Item PRIDE_PUNCH       = register("pride_punch",       new CocktailItem(new Item.Properties().stacksTo(16)));
    public static final Item SUNSET_PRISM      = register("sunset_prism",      new CocktailItem(new Item.Properties().stacksTo(16)));
    public static final Item THE_AMETHYST      = register("the_amethyst",      new CocktailItem(new Item.Properties().stacksTo(16)));
    public static final Item VELVET_ACE        = register("velvet_ace",        new CocktailItem(new Item.Properties().stacksTo(16)));

    private static <T extends Item> T register(String id, T item) {
        return Registry.register(BuiltInRegistries.ITEM, WatheExtended.id(id), item);
    }
    public static void initialize() {}
}
