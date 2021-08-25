package com.argentstew.simulator.battle.trait;

import com.argentstew.simulator.battle.reporting.DamageReport;

/**
 * com.argentstew.simulator.battle.trait
 * 8/25/2021
 *
 * @author argen
 */
public abstract class AbstractArmorTrait implements Trait {

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
        adjustedReport.setDamage(recalculateDamage(report));

        return adjustedReport;
    }

    protected int recalculateDamage(DamageReport report) {
        return report.getDamage();
    }
}
