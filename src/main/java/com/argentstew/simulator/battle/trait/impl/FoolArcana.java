package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.AbstractArmorTrait;
import com.argentstew.simulator.battle.vg.joker.Joker;
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
public class FoolArcana extends AbstractArmorTrait {

    private final String name = "Fool Arcana";

    private String state = null;

    public void setState(String state) {
        this.state = state;
    }

    @Override
    protected int recalculateDamage(DamageReport report) {
        AttackAction attack = report.getAttack();
        int damage = report.getDamage();
        if (state == null) {
            return damage;
        } else if (Joker.PERSONA_ARSENE.equals(state)) {
            return applyArseneArmor(attack, damage);
        } else if (Joker.PERSONA_IZANAGI.equals(state)) {
            return applyIzanagiArmor(attack, damage);
        } else if (Joker.PERSONA_ORPHEUS.equals(state)) {
            return applyOrpheusArmor(attack, damage);
        }

        return damage;
    }

    @Override
    public boolean isImmuneToTorment() {
        return true;
    }

    private int applyArseneArmor(AttackAction attack, int damage) {
        double finalDamage = damage;
        for (AttackSubType subType : attack.getSubtypes()) {
            if (subType.equals(AttackSubType.DARK)) {
                finalDamage *= 0.75;
            } else if (subType.equals(AttackSubType.ICE) || subType.equals(AttackSubType.LIGHT)) {
                finalDamage *= 1.25;
            }
        }

        return (int) Math.round(finalDamage);
    }

    private int applyIzanagiArmor(AttackAction attack, int damage) {
        double finalDamage = damage;
        for (AttackSubType subType : attack.getSubtypes()) {
            if (subType.equals(AttackSubType.DARK) || subType.equals(AttackSubType.THUNDER)) {
                finalDamage *= 0.75;
            } else if (subType.equals(AttackSubType.AIR)) {
                finalDamage *= 1.25;
            }
        }

        return (int) Math.round(finalDamage);
    }

    private int applyOrpheusArmor(AttackAction attack, int damage) {
        double finalDamage = damage;
        for (AttackSubType subType : attack.getSubtypes()) {
            if (subType.equals(AttackSubType.LIGHT)) {
                finalDamage *= 0.75;
            } else if (subType.equals(AttackSubType.THUNDER) || subType.equals(AttackSubType.DARK)) {
                finalDamage *= 1.25;
            }
        }

        return (int) Math.round(finalDamage);
    }
}
