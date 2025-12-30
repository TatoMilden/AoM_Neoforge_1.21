package net.tatomilden.mythologicalages.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.tatomilden.mythologicalages.item.ModItems;

public class WineItem extends Item {
    public WineItem(Item.Properties properties) {super(properties);}

    public static final FoodProperties WINE = new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,600,1),0.25f)
            .usingConvertsTo(ModItems.EMPTY_WINE_BOTTLE)
            .alwaysEdible()
            .build();

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide && livingEntity instanceof Player player){
            Holder<MobEffect> effect = MobEffects.CONFUSION;
            MobEffectInstance actual = player.getEffect((Holder<MobEffect>) effect);

            int newAmplifier = 0;
            int newDuration=100;

            if (actual != null) {
                newAmplifier = actual.getAmplifier() + 1;
            }

            newAmplifier = Math.min(newAmplifier, 3);

            if (newAmplifier==3 && actual!=null){
                newDuration = actual.getDuration() + 100;
            }

            player.addEffect(new MobEffectInstance(
                    effect,
                    newDuration,
                    newAmplifier,
                    false,
                    true
            ));
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
}
