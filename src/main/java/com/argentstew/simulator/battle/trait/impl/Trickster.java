package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.Trait;
import com.argentstew.simulator.battle.vg.joker.Joker;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 3/30/2020
 *
 * @author argen
 */
@Getter
@EqualsAndHashCode
public class Trickster implements Trait {

    private String name = "Trickster";
    private String state = null;

    public Trickster() { }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public double applyBonusDamage(Fighter defender, double rawDamage) {
        return rawDamage;
    }

    @Override
    public AttackAction applyPassiveDefense(AttackAction attack) {
        return null;
    }

    @Override
    public DamageReport applyArmor(DamageReport report) {
        if (report.isMiss()) {
            return report;
        }

        DamageReport adjustedReport = new DamageReport();
        adjustedReport.setDefender(report.getDefender());
        adjustedReport.setAttack(report.getAttack());
        adjustedReport.setMiss(report.isMiss());
        adjustedReport.setCrit(report.isCrit());
        adjustedReport.setStun(report.isStun());
        adjustedReport.setDamage(modifyDamage(report.getAttack(), report.getDamage()));

        return adjustedReport;
    }

    private int modifyDamage(AttackAction attack, int damage) {
        if (state == null) {
            return damage;
        } else if (Joker.PERSONA_ARSENE.equals(state)) {
            return applyArseneArmor(attack, damage);
        } else if (Joker.PERSONA_VISHNU.equals(state)) {
            return applyVishnuArmor(attack, damage);
        } else if (Joker.PERSONA_FUTSUNUSHI.equals(state)) {
            return applyFutsunushiArmor(attack, damage);
        }

        return damage;
    }

    private int applyArseneArmor(AttackAction attack, int damage) {
        double finalDamage = damage;
        for (AttackSubType subType : attack.getSubtypes()) {
            if (subType.equals(AttackSubType.DARK)) {
                finalDamage *= 0.8;
            } else if (subType.equals(AttackSubType.ICE) || subType.equals(AttackSubType.LIGHT)) {
                finalDamage *= 1.2;
            }
        }

        return (int) Math.round(finalDamage);
    }

    private int applyVishnuArmor(AttackAction attack, int damage) {
        double finalDamage = damage;
        for (AttackSubType subType : attack.getSubtypes()) {
            if (subType.equals(AttackSubType.ICE)) {
                finalDamage *= 0.6;
            } else if (subType.equals(AttackSubType.LIGHT) || subType.equals(AttackSubType.DARK)) {
                finalDamage *= 0.8;
            } else if (subType.equals(AttackSubType.FIRE)) {
                finalDamage *= 1.2;
            }
        }

        return (int) Math.round(finalDamage);
    }

    private int applyFutsunushiArmor(AttackAction attack, int damage) {
        double finalDamage = damage;
        if (attack instanceof MeleeAttack) {
            finalDamage *= 0.9;
        }

        for (AttackSubType subType : attack.getSubtypes()) {
            if (subType.equals(AttackSubType.TOXIC)) {
                finalDamage *= 1.25;
            }
        }

        return (int) Math.round(finalDamage);
    }
}
