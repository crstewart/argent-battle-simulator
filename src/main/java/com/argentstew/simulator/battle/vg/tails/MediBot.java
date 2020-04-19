package com.argentstew.simulator.battle.vg.tails;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.peach
 * 8/24/2019
 *
 * @author Craig
 */
public class MediBot extends Heal {

    public MediBot() {
        this.name = "Medi-Bot";
        this.description = "Heals 35-45 damage";
        this.initiateMessage = "prepares his Medi-Bot!";
        this.successMessage = "uses the bot to heal himself!";
        this.failureMessage = "fails to heal!";
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
    public boolean isDoable() {
        return (owner.getHp() < owner.getMaxHp());
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 35;
        double variance = Math.random() * 10;
        return (int) Math.round(baseHeal + variance);
    }
}
