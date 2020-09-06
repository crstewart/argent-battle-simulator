package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.Trait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 11/10/2019
 *
 * @author Craig
 */
@Getter
@EqualsAndHashCode
public class Cheater implements Trait {

    private final String name = "Cheater";

    @Override
    public double applyBonusDamage(Fighter defender, double rawDamage) {
        double damageMultiplier = (Math.random() * 0.2) + 1;

        return rawDamage * damageMultiplier;
    }

    @Override
    public AttackAction applyPassiveDefense(AttackAction attack) {
        return null;
    }

    @Override
    public DamageReport applyArmor(DamageReport report) {
        double damageMultiplier = 1 - (Math.random() * 0.2);
        report.setDamage((int) Math.round(report.getDamage() * damageMultiplier));

        return report;
    }
}
