package net.tatomilden.mythologicalages.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class MadnessEffect extends MobEffect {

    protected MadnessEffect(MobEffectCategory category, int color) {super(category, color);}


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level().isClientSide() || !(livingEntity instanceof Mob mob)) return false;
        Player nearestPlayer = livingEntity.level().getNearestPlayer(livingEntity, 16.0D);
        if (nearestPlayer == null) return false;

        if (mob.getType().getCategory() == MobCategory.MONSTER || isNeutral(mob)){
            mob.setTarget(nearestPlayer);
            mob.setLastHurtByMob(nearestPlayer);
        }else{
            if (mob.getNavigation().isDone()) {
                Vec3 fleePos = DefaultRandomPos.getPosAway((PathfinderMob) mob, 16, 7, nearestPlayer.position());
                if (fleePos != null) {
                    mob.getNavigation().moveTo(fleePos.x, fleePos.y, fleePos.z, 1.2D + (amplifier * 0.1D));
                }
            }
        }
        return true;
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }

    private static boolean isNeutral(Mob mob) {
        return mob instanceof EnderMan
                || mob instanceof IronGolem
                || mob instanceof Wolf
                || mob instanceof Bee
                || mob instanceof Piglin
                || mob instanceof ZombifiedPiglin
                || mob instanceof PolarBear;
    }

}
