package com.argentstew.simulator.battle.vg.bayonetta;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bayonetta
 * 8/24/2019
 *
 * @author Craig
 */
public class WitchTwist extends MagicAttack implements ShapeshiftAction {

    public WitchTwist() {
        super();
        this.name = "Witch Twist";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.requiresMeleeRange = true;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
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
