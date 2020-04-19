package com.argentstew.simulator.battle.vg.inkling;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.inkling
 * 3/26/2020
 *
 * @author argen
 */
public class RefillInk extends Heal {

    public RefillInk() {
        this.setName("Refill Ink");
        this.description = "Restores all SP, acts like a dodge with increased dodge chance";
        this.setInitiateMessage("sinks into the ground to refill their ink!");
        this.setSuccessMessage("fully refills their ink!");
        this.setFailureMessage("fully refills their ink, but is struck by the attack!");
        this.setSpeed(0);
    }

    @Override
    public boolean isSuccessful(AttackAction attack) {
        if (attack == null) {
            return true;
        }

        if (attack.hasCharacteristic(AttackCharacteristic.UNDODGEABLE)) {
            return false;
        }

        return Math.random() < (owner.getStats().getSpeed() * 0.0275 + owner.getStats().getAgility() * 0.0475) * 1.5;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        this.owner.setMp(this.owner.getMaxMp());
        for (Action action : owner.getActions()) {
            if ("Refill Ink".equals(action.getName())) {
                owner.getStrategy().setWeight(action, 0.1);
                break;
            }
        }

        return 0;
    }

    @Override
    public boolean isDoable() {
        return this.owner.getMp() < this.owner.getMaxMp();
    }
}
