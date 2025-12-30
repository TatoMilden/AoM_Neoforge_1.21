package net.tatomilden.mythologicalages.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.tatomilden.mythologicalages.effect.MadnessEffect;
import net.tatomilden.mythologicalages.effect.ModEffects;
import net.tatomilden.mythologicalages.item.ModItems;

public class BerserkMushroomItem extends Item {
    public BerserkMushroomItem(Properties properties) {super(properties);}
    public static final FoodProperties BERSERK_MUSHROOM = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(ModEffects.MADNESS,600),1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,600,1,true,false,false),1f)
            .alwaysEdible()
            .build();
}
