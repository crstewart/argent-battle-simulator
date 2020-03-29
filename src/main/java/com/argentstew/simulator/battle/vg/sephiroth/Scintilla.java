package com.argentstew.simulator.battle.vg.sephiroth;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 8/27/2019
 *
 * @author Craig
 */
public class Scintilla extends Guard {

    public Scintilla() {
        this.name = "Scintilla";
        this.initiateMessage = "uses Scintilla!";
        this.successMessage = "blocks the attack and prepares to counter!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1.5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        if (attack instanceof MeleeAttack) {
            return true;
        }

        if (attack instanceof MagicAttack) {
            return ((MagicAttack) attack).isRequiresMeleeRange();
        }

        return false;
    }

    @Override
    public int applyDefense(int damage) {
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        for (Action action : this.owner.getActions()) {
            if ("Masamune".equals(action.getName())) {
                return (AttackAction) action;
            }
        }

        return null;
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
