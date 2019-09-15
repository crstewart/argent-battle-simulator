package com.argentstew.simulator.battle.vg.mewtwo;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.mewtwo
 * 8/24/2019
 *
 * @author Craig
 */
public class Recover extends Heal {

    public Recover() {
        this.name = "Recover";
        this.initiateMessage = "readies its recovery move!";
        this.successMessage = "uses Recover!";
        this.failureMessage = "could not use Recover!";
        this.speed = 2;
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
        return super.restoreHealth(incomingDamage);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 30;
        double variance = Math.random() * 10;
        return (int) Math.round(baseHeal + variance);
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
