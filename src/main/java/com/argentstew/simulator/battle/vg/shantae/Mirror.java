package com.argentstew.simulator.battle.vg.shantae;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.vg.common.ReflectedMagicAttack;
import com.argentstew.simulator.battle.vg.common.ReflectedRangedAttack;

/**
 * com.argentstew.simulator.battle.vg.shantae
 * 8/27/2019
 *
 * @author Craig
 */
public class Mirror extends Guard implements ShapeshiftAction {

    private static final int MP_COST = 3;

    public Mirror() {
        this.name = "Mirror";
        this.description = "Uses 4 SP; reflects all ranged attacks and magic";
        this.initiateMessage = "uses Mirror!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 0.5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        if (attack instanceof RangedAttack) {
            return true;
        }

        if (attack instanceof MagicAttack) {
            return !attack.isRequiresMeleeRange();
        }

        return false;
    }

    @Override
    public int applyDefense(int damage) {
        owner.useMagic(MP_COST);
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        AttackAction counterAttack = null;
        if (attack instanceof RangedAttack) {
            counterAttack = new ReflectedRangedAttack(attack.getName());
            counterAttack.setOwner(owner);
            counterAttack.setPower(attack.getPower());
            counterAttack.setVariance(attack.getVariance());
            counterAttack.setSpeed(0);
            counterAttack.setSubtypes(attack.getSubtypes());
            counterAttack.setCharacteristics(attack.getCharacteristics());
        } else if (attack instanceof MagicAttack) {
            counterAttack = new ReflectedMagicAttack(attack.getName());
            counterAttack.setOwner(owner);
            counterAttack.setPower(attack.getPower());
            counterAttack.setVariance(attack.getVariance());
            counterAttack.setSpeed(0);
            counterAttack.setSubtypes(attack.getSubtypes());
            counterAttack.setCharacteristics(attack.getCharacteristics());
        }

        return counterAttack;
    }

    @Override
    public boolean isAllowed() {
        return owner.getMp() >= MP_COST;
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
