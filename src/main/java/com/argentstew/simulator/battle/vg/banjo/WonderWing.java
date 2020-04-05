package com.argentstew.simulator.battle.vg.banjo;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.charizard
 * 9/8/2019
 *
 * @author Craig
 */
public class WonderWing extends Guard {

    private int uses;

    public WonderWing() {
        this.name = "Wonderwing";
        this.initiateMessage = "uses Wonderwing!";
        this.successMessage = "was immune to the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1;
        this.uses = 5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        uses--;
        return true;
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
        return uses > 0;
    }
}
