package com.argentstew.simulator.battle.vg.sora;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.sora
 * 8/27/2019
 *
 * @author Craig
 */
public class Counterguard extends Guard {

    public Counterguard() {
        this.name = "Counterguard";
        this.initiateMessage = "uses Counterguard!";
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
        return (int) Math.round(damage * 0.5);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        if (attack instanceof MeleeAttack) {
            Counterattack counter = new Counterattack();
            counter.setOwner(owner);
            return counter;
        }

        return null;
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
