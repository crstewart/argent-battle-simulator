package com.argentstew.simulator.battle.vg.bayonetta;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bayonetta
 * 8/27/2019
 *
 * @author Craig
 */
public class WickedWeavesHekatoncheir extends RangedXStrike implements ShapeshiftAction {

    public WickedWeavesHekatoncheir() {
        super();
        this.name = "Wicked Weaves (Hekatoncheir)";
        this.power = 320;
        this.variance = 20;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
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
