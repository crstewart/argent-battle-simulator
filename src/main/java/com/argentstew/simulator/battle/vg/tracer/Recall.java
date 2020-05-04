package com.argentstew.simulator.battle.vg.tracer;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.tracer
 * 8/24/2019
 *
 * @author Craig
 */
public class Recall extends Heal {

    public Recall() {
        this.name = "Recall";
        this.description = "Restores all damage done by an attack, gains 30 SP";
        this.initiateMessage = "activates her Chronal Accelerator!";
        this.successMessage = "uses Recall to revert time!";
        this.failureMessage = "failed to activate her Recall ability!";
        this.speed = 10;
    }

    @Override
    public boolean isSuccessful(AttackAction attack) {
        double stunChance = 0;
        if (attack instanceof MagicAttack) {
            stunChance = ((-0.03 * Math.pow(owner.getStats().getWillpower(), 1.05)) + 0.4);
        } else {
            stunChance = ((-0.03 * Math.pow(owner.getStats().getToughness(), 1.05)) + 0.4);
        }

        return (Math.random() < stunChance);
    }

    @Override
    public int restoreHealth(int incomingDamage) {
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 30));
        return super.restoreHealth(incomingDamage);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return (owner.getHp() < owner.getMaxHp());
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        return incomingDamage;
    }
}
