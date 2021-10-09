package com.argentstew.simulator.battle.vg.nightmare;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.nightmare
 * 8/27/2019
 *
 * @author Craig
 */
public class DireVengeance extends Guard {

    public DireVengeance() {
        this.name = "Dire Vengeance";
        this.description = "Blocks melee attacks and counters with Soul Wave";
        this.initiateMessage = "takes a defensive stance!";
        this.successMessage = "defends the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return attack instanceof MeleeAttack;
    }

    @Override
    public int applyDefense(int damage) {
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        if (attack instanceof MeleeAttack) {
            SoulWave counter = new SoulWave();
            counter.setOwner(owner);
            return counter;
        }

        return null;
    }

    @Override
    public boolean isAllowed() {
        return true;
    }
}
