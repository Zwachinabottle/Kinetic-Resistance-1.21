package net.zwachinabottle.kineticresistance.damage;

public class ModDamageTracker {
    private static final ThreadLocal<Boolean> BONUS_DAMAGE = ThreadLocal.withInitial(() -> false);

    public static void setBonusDamage(boolean value) {
        BONUS_DAMAGE.set(value);
    }

    public static boolean hasBonusDamage() {
        return BONUS_DAMAGE.get();
    }

    public static void clear() {
        BONUS_DAMAGE.set(false);
    }
}
