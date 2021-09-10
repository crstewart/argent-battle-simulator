package com.argentstew.simulator.battle.vg.decidueye;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.decidueye
 * 8/24/2019
 *
 * @author Craig
 */
public class Synthesis extends Heal {

    private int uses;

    public Synthesis() {
        this.name = "Synthesis";
        this.description = "Has 5 uses; heals 35-45 HP";
        this.initiateMessage = "is enveloped in sunlight!";
        this.successMessage = "uses Synthesis!";
        this.failureMessage = "restored its health!";
        this.speed = 3;
        this.uses = 5;
    }

    @Override
    public boolean isSuccessful(AttackAction attack) {
        double stunChance;
        if (attack instanceof MagicAttack) {
            stunChance = ((-0.03 * Math.pow(owner.getStats().getWillpower(), 1.05)) + 0.4);
        } else {
            stunChance = ((-0.03 * Math.pow(owner.getStats().getToughness(), 1.05)) + 0.4);
        }

        return (Math.random() < stunChance);
    }

    @Override
    public int restoreHealth(int incomingDamage) {
        this.uses--;
        return super.restoreHealth(incomingDamage);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return owner.getHp() < owner.getMaxHp();
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 35;
        double variance = Math.random() * 10;
        return (int) Math.round(baseHeal + variance);
    }
}
