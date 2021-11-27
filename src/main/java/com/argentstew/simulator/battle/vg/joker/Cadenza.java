package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.fighter.FighterStats;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/24/2019
 *
 * @author Craig
 */
public class Cadenza extends Heal {

    public Cadenza() {
        this.name = "Cadenza";
        this.description = "Requires Orpheus, heals 40-45 damage";
        this.initiateMessage = "calls forth Orpheus to cast Cadenza!";
        this.successMessage = "is healed!";
        this.failureMessage = "fails to heal!";
        this.speed = 2;
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
        return (owner.getHp() < owner.getMaxHp() && Joker.PERSONA_ORPHEUS.equals(owner.getSelfStatus()));
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 40;
        double variance = Math.random() * 5;
        return (int) Math.round(baseHeal + variance);
    }
}
