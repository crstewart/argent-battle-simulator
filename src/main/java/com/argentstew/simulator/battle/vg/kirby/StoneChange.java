package com.argentstew.simulator.battle.vg.kirby;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 8/27/2019
 *
 * @author Craig
 */
public class StoneChange extends Guard {

    public StoneChange() {
        this.name = "Stone Change";
        this.initiateMessage = "uses Stone Change!";
        this.successMessage = "was immune to the attack!";
        this.failureMessage = "was changed back!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return !attack.getSubtypes().contains(AttackSubType.GRAPPLE);
    }

    @Override
    public int applyDefense(int damage) {
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        StoneSmash counterAttack = null;
        if (attack instanceof MeleeAttack) {
            counterAttack = new StoneSmash();
        }

        if (attack instanceof MagicAttack) {
            MagicAttack magicAttack = (MagicAttack) attack;
            if (magicAttack.isRequiresMeleeRange()) {
                counterAttack = new StoneSmash();
            }
        }

        if (counterAttack != null) {
            counterAttack.setOwner(this.owner);
        }

        return counterAttack;
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
