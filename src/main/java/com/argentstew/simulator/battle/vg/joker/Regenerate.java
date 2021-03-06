package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/24/2019
 *
 * @author Craig
 */
public class Regenerate extends Heal {

    public Regenerate() {
        this.name = "Regenerate";
        this.description = "Requires Futsunushi, heals 30-36 damage";
        this.initiateMessage = "uses Regenerate 3!";
        this.successMessage = "is healed!";
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
        return (owner.getHp() < owner.getMaxHp() && Joker.PERSONA_FUTSUNUSHI.equals(owner.getSelfStatus()));
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 30;
        double variance = Math.random() * 6;
        return (int) Math.round(baseHeal + variance);
    }
}
