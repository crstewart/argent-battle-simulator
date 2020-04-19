package com.argentstew.simulator.battle.vg.princeofpersia;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.princeofpersia
 * 8/24/2019
 *
 * @author Craig
 */
public class ReverseTime extends Heal {

    public ReverseTime() {
        this.name = "Reverse Time";
        this.description = "Heals for all damage done by an attack";
        this.initiateMessage = "attempts to turn back time!";
        this.successMessage = "reverses time and heals his wounds!";
        this.failureMessage = "failed to use the Dagger of Time!";
        this.speed = 0;
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
        return incomingDamage;
    }
}
