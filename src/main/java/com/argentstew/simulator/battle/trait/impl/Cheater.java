package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.fighter.Fighter;
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
    private final String description = "The fighter does up to 20% additional damage on all attacks and receives 20% " +
            "reduced damage from all incoming attacks.";

    @Override
    public double applyBonusDamage(Fighter defender, double rawDamage) {
        double damageMultiplier = (Math.random() * 0.2) + 1;

        return rawDamage * damageMultiplier;
    }

    @Override
    public DamageReport applyArmor(DamageReport report) {
        double damageMultiplier = 1 - (Math.random() * 0.2);
        report.setDamage((int) Math.round(report.getDamage() * damageMultiplier));

        return report;
    }
}
