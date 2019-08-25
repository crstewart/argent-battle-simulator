package com.argentstew.simulator.battle.action.attack;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.action.attack
 * 8/24/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public abstract class MeleeXStrike extends MeleeAttack implements XStrike {

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.adjustXStrikeMeter(-1 * X_STRIKE_METER_READY);

        return super.doAttack(defender);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 0;
    }

    @Override
    public double getMissChance(Fighter defender) {
        return 0;
    }

    @Override
    public double getStrategyAdjustment(DamageReport report) {
        return 0;
    }

    @Override
    public boolean isDoable() {
        return owner.getXStrikeMeter() >= X_STRIKE_METER_READY;
    }
}
