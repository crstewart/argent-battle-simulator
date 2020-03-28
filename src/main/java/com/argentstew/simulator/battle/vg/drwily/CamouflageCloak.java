package com.argentstew.simulator.battle.vg.drwily;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.drwily
 * 8/24/2019
 *
 * @author Craig
 */
public class CamouflageCloak extends Guard {

    public CamouflageCloak() {
        this.name = "Camouflage Cloak";
        this.initiateMessage = "suddenly disappears!";
        this.successMessage = "avoided the attack!";
        this.failureMessage = "did not fool the attacker!";
        this.speed = 1.5;
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
        return !attack.getCharacteristics().contains(AttackCharacteristic.UNGUARDABLE) &&
                !attack.getCharacteristics().contains(AttackCharacteristic.UNDODGEABLE) &&
                !AttackType.MAGIC.equals(attack.getAttackType());
    }
}
