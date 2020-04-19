package com.argentstew.simulator.battle.vg.tracer;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;

/**
 * com.argentstew.simulator.battle.vg.tracer
 * 4/5/2020
 *
 * @author argen
 */
public class Blink extends Dodge {

    public Blink() {
        this.setName("Blink");
        this.setDescription("Has increased dodge chance, gains 20 SP");
        this.setInitiateMessage("attempts to Blink!");
        this.setSuccessMessage("dodges the attack!");
        this.setFailureMessage("fails to dodge the attack!");
        this.setSpeed(0);
    }

    @Override
    public int applyDefense(int damage) {
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 20));
        return 0;
    }

    @Override
    public boolean isSuccessful(AttackAction attack) {
        if (attack == null) {
            return true;
        }

        if (attack.hasCharacteristic(AttackCharacteristic.UNDODGEABLE)) {
            return false;
        }

        return Math.random() < (owner.getStats().getSpeed() * 0.05 + owner.getStats().getAgility() * 0.05);
    }
}
