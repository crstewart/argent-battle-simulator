package com.argentstew.simulator.battle.vg.bayonetta;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bayonetta
 * 8/24/2019
 *
 * @author Craig
 */
public class PantherWithin extends MeleeAttack implements ShapeshiftAction {

    public PantherWithin() {
        super();
        this.name = "Panther Within";
        this.power = 70;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.CLAW);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean hasClassToReplace() {
        return owner.getClassifications().contains(FighterClassification.HUMANOID);
    }

    @Override
    public void replaceClass() {
        owner.getClassifications().remove(FighterClassification.HUMANOID);
        owner.getClassifications().add(FighterClassification.ANIMAL);
    }
}
