package net.zwachinabottle.kineticresistance.damage;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModDamageSource extends DamageSource {
    private final Identifier tag;

    public ModDamageSource(RegistryEntry name, Identifier tag) {
        super(name);
        this.tag = tag;
    }

    public Identifier getTag() {
        return tag;
    }
}