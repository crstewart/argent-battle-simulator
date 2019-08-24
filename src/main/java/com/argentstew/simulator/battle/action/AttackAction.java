package com.argentstew.simulator.battle.action;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * com.argentstew.simulator.battle.action
 * 8/17/2019
 *
 * @author Craig
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class AttackAction extends Action {

    protected String name;
    protected int power;
    protected double variance;
    protected double speed;
    protected double failureAdjustment;
    protected AttackType attackType;
    protected List<AttackSubType> subtypes;
    protected List<AttackCharacteristic> characteristics;

    public boolean hasCharacteristic(AttackCharacteristic characteristic) {
        if (characteristics == null) {
            return false;
        }

        return characteristics.contains(characteristic);
    }

    public abstract DamageReport doAttack(Fighter defender);

    public abstract double getStrategyAdjustment(DamageReport report);

//    public DamageReport doAttack(Fighter defender) {
//        double bonusDamage = Math.random() * variance;
//        double baseDamage = power + bonusDamage;
//
//        DamageReport report = new DamageReport();
//        report.setAttack(this);
//        if (Math.random() < 0.2) {
//            report.setDamage((int) Math.round(baseDamage * 2));
//            report.setCrit(true);
//        } else {
//            report.setDamage((int) Math.round(baseDamage));
//            report.setCrit(false);
//        }
//
//        return report;
//    }
//
//    public double getStrategyAdjustment(DamageReport report) {
//        if (report.isMiss()) {
//            return -0.1;
//        }
//        double expectedDamage = power + (variance / 2.0);
//        if (report.isCrit()) {
//            expectedDamage *= 2;
//        }
//
//        return report.getDamage() - expectedDamage;
//    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
