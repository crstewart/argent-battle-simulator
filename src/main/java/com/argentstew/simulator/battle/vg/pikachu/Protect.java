package com.argentstew.simulator.battle.vg.pikachu;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 8/27/2019
 *
 * @author Craig
 */
public class Protect extends Guard {

    private int uses;

    public Protect() {
        this.name = "Protect";
        this.description = "Has 5 uses, blocks all non-stealth attacks; absorbs only 75% damage from characters size 7 or higher";
        this.initiateMessage = "protects itself!";
        this.successMessage = "successfully foiled the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 0.5;
        this.uses = 5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        this.uses -= 1;
        return !attack.getCharacteristics().contains(AttackCharacteristic.STEALTH);
    }

    @Override
    public int applyDefense(int damage) {
        return (owner.getArena().getOpponent(owner).getStats().getSize() >= 7) ? (int) Math.round(damage * 0.25) : 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isAllowed() {
        return uses > 0;
    }
}
