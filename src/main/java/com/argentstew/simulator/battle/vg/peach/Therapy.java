package com.argentstew.simulator.battle.vg.peach;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.peach
 * 8/24/2019
 *
 * @author Craig
 */
public class Therapy extends Heal {

    public static final int MP_COST = 2;

    public Therapy() {
        this.name = "Therapy";
        this.description = "Heals at least 30 damage";
        this.initiateMessage = "prepares to cast a spell!";
        this.successMessage = "casts Therapy!";
        this.failureMessage = "failed to cast Therapy!";
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
        owner.useMagic(MP_COST);
        return super.restoreHealth(incomingDamage);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return (owner.getMp() >= MP_COST) && (owner.getHp() < owner.getMaxHp());
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 30 + (owner.getStats().getIntellect() * 0.4);
        double variance = Math.random() * 8;
        return (int) Math.round(baseHeal + variance);
    }
}
