package com.argentstew.simulator.battle.vg.mallow;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.fighter.FighterStats;

/**
 * com.argentstew.simulator.battle.vg.mallow
 * 8/24/2019
 *
 * @author Craig
 */
public class HPRain extends Heal {

    public HPRain() {
        this.name = "HP Rain";
        this.description = "Heals at least 25 damage";
        this.initiateMessage = "prepares to cast a spell!";
        this.successMessage = "casts HP Rain!";
        this.failureMessage = "failed to cast HP Rain!";
        this.speed = 0;
    }

    @Override
    public boolean isSuccessful(AttackAction attack) {
        double stunChance;
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
        return owner.getHp() < owner.getMaxHp();
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 25 + (owner.getStat(FighterStats.INTELLECT) * 0.4);
        double variance = Math.random() * 12;
        return (int) Math.round(baseHeal + variance);
    }
}
