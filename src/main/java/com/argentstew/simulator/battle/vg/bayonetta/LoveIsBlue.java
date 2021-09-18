package com.argentstew.simulator.battle.vg.bayonetta;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bayonetta
 * 8/24/2019
 *
 * @author Craig
 */
public class LoveIsBlue extends RangedAttack implements ShapeshiftAction {

    public LoveIsBlue() {
        super();
        this.name = "Love is Blue";
        this.power = 65;
        this.variance = 8;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
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
