package com.argentstew.simulator.battle.vg.pikachu;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.vg.zelda.ReflectedMagicAttack;
import com.argentstew.simulator.battle.vg.zelda.ReflectedRangedAttack;

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
        this.initiateMessage = "protects itself!";
        this.successMessage = "successfully foiled the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 0.5;
        this.uses = 5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        this.uses -= 1;
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
