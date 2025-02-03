package net.zwachinabottle.kineticresistance.tags;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.zwachinabottle.kineticresistance.KineticResistance;

public class KineticResistantTags {
    public static final TagKey<DamageType> KINETIC = TagKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(KineticResistance.MOD_ID, "kinetic"));

}
