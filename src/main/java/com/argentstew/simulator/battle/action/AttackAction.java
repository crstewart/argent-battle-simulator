package com.argentstew.simulator.battle.action;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
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

    protected int power;
    protected double variance;
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

    public abstract double getFailureAdjustment();

    @Override
    public double calculateSpeed() {
        return speed;
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
