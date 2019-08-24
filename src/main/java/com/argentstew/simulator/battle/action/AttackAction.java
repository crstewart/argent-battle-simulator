package com.argentstew.simulator.battle.action;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * com.argentstew.simulator.battle.action
 * 8/17/2019
 *
 * @author Craig
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class AttackAction extends Action {

    private String name;
    private int power;
    private double variance;
    private int speed;
    private double stunChance;
    private double failureAdjustment;
    private ActionType type;
    private List<AttackSubType> subtypes;
    private List<AttackCharacteristic> characteristics;

    public boolean hasCharacteristic(AttackCharacteristic characteristic) {
        if (characteristics == null) {
            return false;
        }

        return characteristics.contains(characteristic);
    }

    public DamageReport doAttack(Fighter defender) {
        double bonusDamage = Math.random() * variance;
        double baseDamage = power + bonusDamage;

        DamageReport report = new DamageReport();
        report.setAttack(this);
        if (Math.random() < 0.2) {
            report.setDamage((int) Math.round(baseDamage * 2));
            report.setCrit(true);
        } else {
            report.setDamage((int) Math.round(baseDamage));
            report.setCrit(false);
        }

        return report;
    }

    public double getStrategyAdjustment(DamageReport report) {
        if (report.isMiss()) {
            return -0.1;
        }
        double expectedDamage = power + (variance / 2.0);
        if (report.isCrit()) {
            expectedDamage *= 2;
        }

        return report.getDamage() - expectedDamage;
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
