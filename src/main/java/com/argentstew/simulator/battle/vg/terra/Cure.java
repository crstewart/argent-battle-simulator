package com.argentstew.simulator.battle.vg.terra;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.fighter.FighterStats;

/**
 * com.argentstew.simulator.battle.vg.terra
 * 8/24/2019
 *
 * @author Craig
 */
public class Cure extends Heal {

    private static final String LEVEL1 = "Cure";
    private static final String LEVEL2 = "Cura";
    private static final String LEVEL3 = "Curaga";

    private int healAmount;

    public Cure() {
        this.name = LEVEL1;
        this.description = "Has three levels of power, upgrading with each successful heal";
        this.initiateMessage = "chants a white magic spell!";
        this.successMessage = "casts";
        this.failureMessage = "failed to cast";
        this.speed = 1.5;
        this.healAmount = 10;
    }

    @Override
    public String getBaseName() {
        return LEVEL1;
    }

    @Override
    public String getSuccessMessage() {
        return successMessage + " " + name + "!";
    }

    @Override
    public String getFailureMessage() {
        return failureMessage + " " + name + "!";
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
        if (LEVEL1.equals(name)) {
            name = LEVEL2;
            healAmount = 20;
        } else if (LEVEL2.equals(name)) {
            name = LEVEL3;
            healAmount = 35;
        }

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
        double baseHeal = healAmount + (owner.getStat(FighterStats.INTELLECT) * 0.4);
        double variance = Math.random() * 10;
        return (int) Math.round(baseHeal + variance);
    }
}
