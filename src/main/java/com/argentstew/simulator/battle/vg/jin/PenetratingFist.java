package com.argentstew.simulator.battle.vg.jin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jin
 * 8/24/2019
 *
 * @author Craig
 */
public class PenetratingFist extends RangedAttack implements ShapeshiftAction {

    public PenetratingFist() {
        super();
        this.name = "Penetrating Fist";
        this.description = "Changes the user into demonic form until another form is taken";
        this.power = 60;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean hasClassToReplace() {
        return owner.getClassifications().contains(FighterClassification.HUMANOID);
    }

    @Override
    public void replaceClass() {
        owner.getClassifications().remove(FighterClassification.HUMANOID);
        owner.getClassifications().add(FighterClassification.DEMONIC);
    }
}
