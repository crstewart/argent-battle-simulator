package com.argentstew.simulator.battle.vg.geralt;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.geralt
 * 8/24/2019
 *
 * @author Craig
 */
public class HeliotropSign extends Guard {

    public HeliotropSign() {
        this.name = "Heliotrop Sign";
        this.initiateMessage = "crosses his wrists over his chest!";
        this.successMessage = "blocks the attack with Heliotrop!";
        this.failureMessage = "was still struck by the attack!";
        this.speed = 0;
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
        return attack instanceof MeleeAttack || attack instanceof MagicAttack;
    }
}
