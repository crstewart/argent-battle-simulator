package com.argentstew.simulator.battle.vg.palutena;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.fighter.FighterStats;

/**
 * com.argentstew.simulator.battle.vg.palutena
 * 8/24/2019
 *
 * @author Craig
 */
public class HealthRecovery extends Heal {

    private static final int EQUIP_COST = 6;

    private boolean used = false;

    public HealthRecovery() {
        this.name = "Health Recovery";
        this.description = "Heals at least 30 damage";
        this.initiateMessage = "prepares a recovery ability!";
        this.successMessage = "uses Health Recovery!";
        this.failureMessage = "failed to recover health!";
        this.speed = 0;
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
        if (!used) {
            used = true;
            owner.restoreMagic(EQUIP_COST);
        }

        return super.restoreHealth(incomingDamage);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isAllowed() {
        return used || owner.getMp() + EQUIP_COST <= owner.getMaxMp();
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 30;
        double variance = Math.random() * 10;
        return (int) Math.round(baseHeal + variance);
    }
}
