package com.argentstew.simulator.battle.vg.ellie;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.fighter.FighterStats;

/**
 * com.argentstew.simulator.battle.vg.ellie
 * 8/24/2019
 *
 * @author Craig
 */
public class MedKit extends Heal {

    public MedKit() {
        this.name = "Therapy";
        this.description = "Heals at least 30 damage";
        this.initiateMessage = "pulls out a med kit!";
        this.successMessage = "treats her wounds!";
        this.failureMessage = "could not use first aid!";
        this.speed = 1;
    }

    @Override
    public boolean isSuccessful(AttackAction attack) {
        double stunChance = 0;
        if (attack instanceof MagicAttack) {
            stunChance = ((-0.03 * Math.pow(owner.getStat(FighterStats.WILLPOWER), 1.05)) + 0.4);
        } else {
            stunChance = ((-0.03 * Math.pow(owner.getStat(FighterStats.TOUGHNESS), 1.05)) + 0.4);
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
    public boolean isAllowed() {
        return true;
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 30;
        double variance = Math.random() * 6;
        return (int) Math.round(baseHeal + variance);
    }
}
