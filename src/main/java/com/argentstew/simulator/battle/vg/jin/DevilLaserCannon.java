package com.argentstew.simulator.battle.vg.jin;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.jin
 * 8/24/2019
 *
 * @author Craig
 */
public class DevilLaserCannon extends RangedXStrike implements ShapeshiftAction {

    public DevilLaserCannon() {
        super();
        this.name = "Devil Laser Cannon";
        this.description = "Changes the user into demonic form until another form is taken";
        this.power = 250;
        this.variance = 15;
        this.speed = 2.5;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.PLASMA);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
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
