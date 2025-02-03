package net.zwachinabottle.kineticresistance.enchantment;

import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.loot.condition.AllOfLootCondition;
import net.minecraft.loot.condition.DamageSourcePropertiesLootCondition;
import net.minecraft.predicate.TagPredicate;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.zwachinabottle.kineticresistance.KineticResistance;
import net.zwachinabottle.kineticresistance.tags.KineticResistantTags;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> KINETIC_RESISTANT =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(KineticResistance.MOD_ID, "kinetic_resistance"));

    public static void bootstrap(Registerable<Enchantment> registerable){
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, KINETIC_RESISTANT, Enchantment.builder(Enchantment.definition(

                items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                items.getOrThrow(ItemTags.EQUIPPABLE_ENCHANTABLE),
                5,4,Enchantment.leveledCost(10, 8),
                Enchantment.leveledCost(18, 8),2,
                                        AttributeModifierSlot.ARMOR,AttributeModifierSlot.CHEST
                                )
                        )
                        .addEffect(
                                EnchantmentEffectComponentTypes.DAMAGE_PROTECTION,
                                new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(2.0F)),
                                AllOfLootCondition.builder(
                                        DamageSourcePropertiesLootCondition.builder(
                                                DamageSourcePredicate.Builder.create()
                                                        .tag(TagPredicate.expected(KineticResistantTags.KINETIC))
                                                        .tag(TagPredicate.unexpected(DamageTypeTags.BYPASSES_INVULNERABILITY))
                                        )
                                )
                        )
        );


    }


    public static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder){
        registry.register(key,builder.build(key.getValue()));
    }
}
