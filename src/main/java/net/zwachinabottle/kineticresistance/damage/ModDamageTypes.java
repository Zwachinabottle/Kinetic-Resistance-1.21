package net.zwachinabottle.kineticresistance.damage;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> MACE_DAMAGE_TYPE =
            RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("kineticresistance", "mace_bonus_damage"));

    public static void bootstrap(Registerable<DamageType> registry) {
        registry.register(MACE_DAMAGE_TYPE, new DamageType("mace", 0.0f));
    }
}
