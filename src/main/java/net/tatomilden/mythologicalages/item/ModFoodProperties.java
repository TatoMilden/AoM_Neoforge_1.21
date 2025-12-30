package net.tatomilden.mythologicalages.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties RAGWEED = new FoodProperties.Builder().nutrition(8).saturationModifier(1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION,300,2),0.75f).build();
}
