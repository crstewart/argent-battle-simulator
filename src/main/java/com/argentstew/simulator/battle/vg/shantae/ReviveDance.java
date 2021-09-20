package com.argentstew.simulator.battle.vg.shantae;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.fighter.FighterStats;

/**
 * com.argentstew.simulator.battle.vg.shantae
 * 8/24/2019
 *
 * @author Craig
 */
public class ReviveDance extends Heal implements ShapeshiftAction {

    public static final int MP_COST = 2;

    public ReviveDance() {
        this.name = "Therapy";
        this.description = "Uses 2 SP; heals at least 40 damage";
        this.initiateMessage = "begins a healing belly dance!";
        this.successMessage = "uses Revive Dance!";
        this.failureMessage = "failed to use her healing ability!";
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
        owner.useMagic(MP_COST);
        return super.restoreHealth(incomingDamage);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isAllowed() {
        return (owner.getMp() >= MP_COST) && (owner.getHp() < owner.getMaxHp());
    }

    @Override
    protected int calculateAmountHealed(int incomingDamage) {
        double baseHeal = 40;
        double variance = Math.random() * 10;
        return (int) Math.round(baseHeal + variance);
    }

    @Override
    public boolean hasClassToReplace() {
        return owner.getClassifications().contains(FighterClassification.ANIMAL);
    }

    @Override
    public void replaceClass() {
        owner.getClassifications().remove(FighterClassification.ANIMAL);
        owner.getClassifications().add(FighterClassification.HUMANOID);
    }
}
