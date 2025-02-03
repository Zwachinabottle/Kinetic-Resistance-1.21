package net.zwachinabottle.kineticresistance.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.zwachinabottle.kineticresistance.damage.ModDamageTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Redirect(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/damage/DamageSources;playerAttack(Lnet/minecraft/entity/player/PlayerEntity;)Lnet/minecraft/entity/damage/DamageSource;"))
    public DamageSource onDamageDeltWithWeaponInHand(DamageSources instance, PlayerEntity attacker, @Local ItemStack stack) {
        if(stack.getItem() instanceof MaceItem) {
            return instance.create(ModDamageTypes.MACE_DAMAGE_TYPE, attacker);
        }

        return instance.playerAttack(attacker);
    }
}
