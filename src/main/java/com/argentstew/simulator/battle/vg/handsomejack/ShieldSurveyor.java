package com.argentstew.simulator.battle.vg.handsomejack;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.vg.common.ReflectedRangedAttack;

/**
 * com.argentstew.simulator.battle.vg.handsomejack
 * 8/24/2019
 *
 * @author Craig
 */
public class ShieldSurveyor extends Guard {

    public ShieldSurveyor() {
        this.name = "Shield Surveyor";
        this.description = "Blocks all guardable non-magic attacks";
        this.initiateMessage = "calls for his personal Shield Surveyor!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to block the attack!";
        this.speed = 1;
    }

    @Override
    public int applyDefense(int damage) {
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return true;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return !(attack instanceof MagicAttack);
    }
}
