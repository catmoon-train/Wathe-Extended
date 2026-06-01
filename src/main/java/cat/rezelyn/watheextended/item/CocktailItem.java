package cat.rezelyn.watheextended.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

/**
 * Drinkable cocktail item. Follows StarRailExpress's CocktailItem pattern
 * (io.wifi.starrailexpress.content.item.CocktailItem).
 */
public class CocktailItem extends Item {
    public CocktailItem(Settings settings) {
        super(settings.food(FoodComponents.HONEY_BOTTLE));
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 40;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity) user, stack);
        user.emitGameEvent(GameEvent.DRINK);
        return stack;
    }
}
