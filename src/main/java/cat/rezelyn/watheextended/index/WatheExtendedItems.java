package cat.rezelyn.watheextended.index;

import cat.rezelyn.watheextended.WatheExtended;
import cat.rezelyn.watheextended.item.GuidebookItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class WatheExtendedItems {

    public static final Item GUIDEBOOK = register("guidebook", new GuidebookItem(new Item.Settings().maxCount(1)));

    private static <T extends Item> T register(String id, T item) {
        return Registry.register(Registries.ITEM, WatheExtended.id(id), item);
    }

    public static void initialize() {}
}
