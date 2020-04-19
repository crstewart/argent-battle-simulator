package com.argentstew.simulator.battle.vg.jaina;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.jaina
 * 8/27/2019
 *
 * @author Craig
 */
public class IceBlock extends Guard {

    public IceBlock() {
        this.name = "Ice Block";
        this.description = "Blocks all magic attacks, except for fire";
        this.initiateMessage = "casts Ice Block!";
        this.successMessage = "was immune to the attack!";
        this.failureMessage = "could not defend against the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return attack instanceof MagicAttack && !(attack.getSubtypes().contains(AttackSubType.FIRE));
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
