package com.argentstew.simulator.battle.vg.jin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jin
 * 8/24/2019
 *
 * @author Craig
 */
public class DevilBeam extends RangedAttack implements ShapeshiftAction {

    public DevilBeam() {
        super();
        this.name = "Devil Beam";
        this.description = "Changes the user into demonic form until another form is taken";
        this.power = 45;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.PLASMA);
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
