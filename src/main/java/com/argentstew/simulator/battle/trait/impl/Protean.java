package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.AbstractArmorTrait;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 3/30/2020
 *
 * @author argen
 */
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Protean extends AbstractArmorTrait {

    public static final String WATER_TYPE = "Type: Water";
    public static final String GHOST_TYPE = "Type: Ghost";
    public static final String DARK_TYPE = "Type: Dark";
    public static final String FIGHTING_TYPE = "Type: Fighting";

    private final String name = "Protean";

    private String state = WATER_TYPE;

    public void setState(String state) {
        this.state = state;
    }

    @Override
    protected int recalculateDamage(DamageReport report) {
        AttackAction attack = report.getAttack();
        int damage = report.getDamage();
        if (state == null) {
            return damage;
        } else if (WATER_TYPE.equals(state)) {
            return applyWaterType(attack, damage);
        } else if (GHOST_TYPE.equals(state)) {
            return applyGhostType(attack, damage);
        } else if (DARK_TYPE.equals(state)) {
            return applyDarkType(attack, damage);
        } else if (FIGHTING_TYPE.equals(state)) {
            return applyFightingType(attack, damage);
        }

        return damage;
    }

    private int applyWaterType(AttackAction attack, int damage) {
        double finalDamage = damage;
        for (AttackSubType subType : attack.getSubtypes()) {
            if (subType.equals(AttackSubType.FIRE) || subType.equals(AttackSubType.WATER)
                    || subType.equals(AttackSubType.ICE)) {
                finalDamage *= 0.5;
            } else if (subType.equals(AttackSubType.HANDGUN) || subType.equals(AttackSubType.RIFLE)
                    || subType.equals(AttackSubType.SHOTGUN)) {
                finalDamage *= 0.75;
            } else if (subType.equals(AttackSubType.THUNDER) || subType.equals(AttackSubType.NATURE)) {
                finalDamage *= 2;
            }
        }

        return (int) Math.round(finalDamage);
    }

    private int applyGhostType(AttackAction attack, int damage) {
        double finalDamage = damage;
        for (AttackSubType subType : attack.getSubtypes()) {
            if (subType.equals(AttackSubType.PUNCH) || subType.equals(AttackSubType.KICK)
                    || subType.equals(AttackSubType.HEADBUTT) || subType.equals(AttackSubType.GRAPPLE)
                    || subType.equals(AttackSubType.TAIL) || subType.equals(AttackSubType.CHI)) {
                finalDamage *= 0.25;
            } else if (subType.equals(AttackSubType.TOXIC) || subType.equals(AttackSubType.NATURE)) {
                finalDamage *= 0.5;
            } else if (subType.equals(AttackSubType.DARK) || subType.equals(AttackSubType.BITE)) {
                finalDamage *= 2;
            }
        }

        return (int) Math.round(finalDamage);
    }

    private int applyDarkType(AttackAction attack, int damage) {
        double finalDamage = damage;
        for (AttackSubType subType : attack.getSubtypes()) {
            if (subType.equals(AttackSubType.MYSTIC)) {
                finalDamage *= 0.25;
            } else if (subType.equals(AttackSubType.DARK) || subType.equals(AttackSubType.BITE)) {
                finalDamage *= 0.5;
            } else if (subType.equals(AttackSubType.PUNCH) || subType.equals(AttackSubType.KICK)
                    || subType.equals(AttackSubType.HEADBUTT) || subType.equals(AttackSubType.GRAPPLE)
                    || subType.equals(AttackSubType.TAIL) || subType.equals(AttackSubType.CHI)
                    || subType.equals(AttackSubType.NATURE) || subType.equals(AttackSubType.LIGHT)) {
                finalDamage *= 2;
            }
        }

        return (int) Math.round(finalDamage);
    }

    private int applyFightingType(AttackAction attack, int damage) {
        double finalDamage = damage;
        for (AttackSubType subType : attack.getSubtypes()) {
            if (subType.equals(AttackSubType.NATURE) || subType.equals(AttackSubType.EARTH)
                    || subType.equals(AttackSubType.DARK)) {
                finalDamage *= 0.5;
            } else if (subType.equals(AttackSubType.AIR) || subType.equals(AttackSubType.MYSTIC)
                    || subType.equals(AttackSubType.LIGHT)) {
                finalDamage *= 2;
            }
        }

        return (int) Math.round(finalDamage);
    }

    @Override
    public boolean isImmuneToTorment() {
        return true;
    }
}
