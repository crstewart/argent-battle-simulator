package com.argentstew.simulator.battle.vg.sora;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.erdrick
 * 8/24/2019
 *
 * @author Craig
 */
public class Cure extends Heal {

    public static final int MP_COST = 4;

    public Cure() {
        this.name = "Cure";
        this.description = "Heals more than 32 damage";
        this.initiateMessage = "prepares to cast Cure!";
        this.successMessage = "casts Cure!";
        this.failureMessage = "failed to cast Cure!";
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
        double baseHeal = 32 + (owner.getStats().getIntellect() * 0.4);
        double variance = Math.random() * 10;
        return (int) Math.round(baseHeal + variance);
    }
}
