package com.argentstew.simulator.battle.vg.jin;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
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
public class Stonehead extends MeleeAttack implements ShapeshiftAction {

    public Stonehead() {
        super();
        this.name = "Stonehead";
        this.description = "Changes the user into humanoid form until another form is taken";
        this.power = 35;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.HEADBUTT, AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }

    @Override
    public boolean hasClassToReplace() {
        return owner.getClassifications().contains(FighterClassification.DEMONIC);
    }

    @Override
    public void replaceClass() {
        owner.getClassifications().remove(FighterClassification.DEMONIC);
        owner.getClassifications().add(FighterClassification.HUMANOID);
    }
}
