package cat.rezelyn.watheextended.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

/**
 * Drinkable cocktail item following StarRailExpress's CocktailItem pattern.
 */
public class CocktailItem extends Item {
    public CocktailItem(Properties settings) { super(settings.food(Foods.HONEY_BOTTLE)); }

    @Override public UseAnim getUseAnimation(ItemStack stack) { return UseAnim.DRINK; }
    @Override public SoundEvent getEatingSound() { return SoundEvents.GENERIC_DRINK; }
    @Override public int getUseDuration(ItemStack stack, LivingEntity user) { return 40; }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        super.finishUsingItem(stack, world, user);
        if (user instanceof ServerPlayer serverPlayer) {
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
        }
        user.gameEvent(GameEvent.DRINK);
        return stack;
    }
}
