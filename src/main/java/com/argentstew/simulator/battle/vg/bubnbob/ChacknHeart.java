package com.argentstew.simulator.battle.vg.bubnbob;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.bubnbob
 * 9/8/2019
 *
 * @author Craig
 */
public class ChacknHeart extends Guard {

    private int charge;

    public ChacknHeart() {
        this.name = "Chack'n Heart";
        this.description = "Blocks all attacks, but requires landing 5 attacks to refresh";
        this.initiateMessage = "grabs a Chack'n Heart!";
        this.successMessage = "was immune to the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 4.5;
        this.charge = 5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        charge = 0;
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
    public boolean isAllowed() {
        return charge >= 5;
    }

    public void addCharge() {
        charge++;
    }
}
