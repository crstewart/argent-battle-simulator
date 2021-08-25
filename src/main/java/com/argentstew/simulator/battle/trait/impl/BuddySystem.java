package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.Trait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 8/24/2021
 *
 * @author argen
 */
@Getter
@EqualsAndHashCode
public class BuddySystem implements Trait {

    private final String name = "Buddy System";

    @Override
    public double applyBonusPriority(Action action, double speed) {
        return (action.getOwner().getHp() > action.getOwner().getMaxHp() / 2) ? speed - 4 : speed;
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
        if ((report.getDefender().getHp() > report.getDefender().getMaxHp() / 2)
                && report.getAttack().getSubtypes().contains(AttackSubType.ASSIST)) {
            adjustedReport.setDamage((int) Math.round(report.getDamage() * 0.5));
        } else {
            adjustedReport.setDamage(report.getDamage());
        }

        return adjustedReport;
    }
}
