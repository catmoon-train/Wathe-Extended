package cat.rezelyn.watheextended.item;

import net.minecraft.world.food.Foods;

/**
 * Drinkable cocktail item following StarRailExpress's CocktailItem pattern.
 */
public class CocktailItem extends io.wifi.starrailexpress.content.item.CocktailItem {
    public CocktailItem(Properties settings) {
        super(settings.food(Foods.HONEY_BOTTLE));
    }
}
