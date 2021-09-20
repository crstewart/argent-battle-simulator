package com.argentstew.simulator.battle.vg.shantae;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.fighter.FighterClassification;

/**
 * com.argentstew.simulator.battle.vg.shantae
 * 8/24/2019
 *
 * @author Craig
 */
public class PikeBall extends Guard implements ShapeshiftAction {

    private static final int MP_COST = 3;

    public PikeBall() {
        this.name = "Pike Ball";
        this.description = "Uses 3 SP, has a 75% chance to block melee and ranged attacks";
        this.initiateMessage = "uses the Pike Ball!";
        this.successMessage = "blocked the attack!";
        this.failureMessage = "failed to defend against the attack!";
        this.speed = 0.5;
    }

    @Override
    public int applyDefense(int damage) {
        owner.useMagic(MP_COST);
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isAllowed() {
        return owner.getMp() >= MP_COST;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return Math.random() < 0.75;
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
