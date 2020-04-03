package com.argentstew.simulator.battle.vg.kratos;

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
public class GoldenFleece extends Guard {

    public GoldenFleece() {
        this.name = "Golden Fleece";
        this.initiateMessage = "guards himself with the Golden Fleece";
        this.successMessage = "defends the attack and counters!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return attack instanceof MeleeAttack || attack instanceof MagicAttack;
    }

    @Override
    public int applyDefense(int damage) {
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        for (Action action : this.owner.getActions()) {
            if (attack instanceof MeleeAttack && "Blades of Chaos".equals(action.getName())) {
                return (AttackAction) action;
            } else if (attack instanceof MagicAttack && "Zeus' Fury".equals(action.getName())) {
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
