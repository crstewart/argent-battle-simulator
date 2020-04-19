package com.argentstew.simulator.battle.vg.vyse;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.vg.kirby.StoneSmash;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 8/27/2019
 *
 * @author Craig
 */
public class Counterstrike extends Guard {

    public static final int MP_COST = 1;

    public Counterstrike() {
        this.name = "Counterstrike";
        this.description = "Uses 1 SP, blocks all guardable attacks reducing damage by 50% and countering";
        this.initiateMessage = "takes a defensive stance!";
        this.successMessage = "defends the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        this.owner.useMagic(MP_COST);
        return true;
    }

    @Override
    public int applyDefense(int damage) {
        return (int) Math.round(damage * 0.5);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        for (Action action : this.owner.getActions()) {
            if ("Pirate Cutlass".equals(action.getName())) {
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
