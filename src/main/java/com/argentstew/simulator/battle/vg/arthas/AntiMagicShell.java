package com.argentstew.simulator.battle.vg.arthas;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.arthas
 * 8/27/2019
 *
 * @author Craig
 */
public class AntiMagicShell extends Guard {

    public AntiMagicShell() {
        this.name = "Anti-Magic Shell";
        this.initiateMessage = "casts Anti-Magic Shell!";
        this.successMessage = "was immune to the attack!";
        this.failureMessage = "could not defend against the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return attack instanceof MagicAttack;
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
}
