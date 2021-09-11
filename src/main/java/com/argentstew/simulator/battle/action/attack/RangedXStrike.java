package com.argentstew.simulator.battle.action.attack;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusType;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.action.attack
 * 8/24/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public abstract class RangedXStrike extends RangedAttack implements XStrike {

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.adjustXStrikeMeter(-1 * X_STRIKE_METER_READY);

        if (owner.getStatus() != null && owner.getStatus().getType() == StatusType.SLEEP) {
            owner.setStatus(null);
        }

        if (defender.getStatus() != null && defender.getStatus().getType() == StatusType.SLEEP) {
            defender.getStatus().setForRemovalNextTurn();
        }

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
    public boolean isAllowed() {
        return owner.getXStrikeMeter() >= X_STRIKE_METER_READY;
    }
}
