package com.argentstew.simulator.battle.vg.heavy;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.peach
 * 8/24/2019
 *
 * @author Craig
 */
public class Sandvich extends Heal {

    private int uses;

    public Sandvich() {
        this.name = "Sandvich";
        this.description = "Heals 50-75 damage";
        this.initiateMessage = "pulls out his Sandvich!";
        this.successMessage = "eats his beloved Sandvich!";
        this.failureMessage = "is stopped before he can eat!";
        this.speed = 1.5;
        this.uses = 1;
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
        uses -= 1;
        return super.restoreHealth(incomingDamage);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return (uses > 0) && (owner.getHp() < owner.getMaxHp());
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 50;
        double variance = Math.random() * 25;
        return (int) Math.round(baseHeal + variance);
    }
}
