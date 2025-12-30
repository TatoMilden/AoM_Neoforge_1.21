package net.tatomilden.mythologicalages.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tatomilden.mythologicalages.MythologicalAges;

import static net.tatomilden.mythologicalages.MythologicalAges.MOD_ID;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, MOD_ID);

    public static final Holder<MobEffect> MADNESS = MOB_EFFECTS.register("madness",
            () -> new MadnessEffect(MobEffectCategory.NEUTRAL,0x850101)
                    .addAttributeModifier(Attributes.ATTACK_SPEED,
                            ResourceLocation.fromNamespaceAndPath(MOD_ID,"madness_speed"),0.25f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(MOD_ID,"madness_damage"),0.50f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
