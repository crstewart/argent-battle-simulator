package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.Trait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 3/27/2020
 *
 * @author argen
 */
@Getter
@EqualsAndHashCode
public class MechRider implements Trait {

    private final String name = "Mech Rider";

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
        adjustedReport.setDamage(report.isCrit() ? (int) Math.round(report.getDamage() * 1.25) :
                (int) Math.round(report.getDamage() * 0.8));

        return adjustedReport;
    }
}
