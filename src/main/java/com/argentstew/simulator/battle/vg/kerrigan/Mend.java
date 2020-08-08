package com.argentstew.simulator.battle.vg.kerrigan;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.kerrigan
 * 8/24/2019
 *
 * @author Craig
 */
public class Mend extends Heal {

    public Mend() {
        this.name = "Mend";
        this.description = "Heals 45-60 damage";
        this.initiateMessage = "assimilates her spawned zerg!";
        this.successMessage = "mends her wounds!";
        this.failureMessage = "fails to heal!";
        this.speed = 1;
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
    public boolean isDoable() {
        return (owner.getHp() < owner.getMaxHp());
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 45;
        double variance = Math.random() * 15;
        return (int) Math.round(baseHeal + variance);
    }
}
