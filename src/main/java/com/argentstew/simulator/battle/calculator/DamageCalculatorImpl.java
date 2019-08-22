package com.argentstew.simulator.battle.calculator;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

/**
 * com.argentstew.simulator.battle.calculator
 * 8/21/2019
 *
 * @author Craig
 */
public class DamageCalculatorImpl implements DamageCalculator {

    @Override
    public DamageReport calculateDamage(AttackAction attack, Fighter defender) {
        double baseDamage = calculateBaseDamage(attack);
        DamageReport report = new DamageReport();
        report.setAttack(attack);
        if (Math.random() < 0.2) {
            report.setDamage((int) Math.round(baseDamage * 2));
            report.setCrit(true);
        } else {
            report.setDamage((int) Math.round(baseDamage));
            report.setCrit(false);
        }

        return report;
    }

    private double calculateBaseDamage(AttackAction attack) {
        int baseAttack = attack.getPower();
        double bonusDamage = Math.random() * attack.getVariance();
        return baseAttack + bonusDamage;
    }
}
