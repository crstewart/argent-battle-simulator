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
public class AfterBurnerKick extends MeleeAttack implements ShapeshiftAction {

    public AfterBurnerKick() {
        super();
        this.name = "After Burner Kick";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
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
