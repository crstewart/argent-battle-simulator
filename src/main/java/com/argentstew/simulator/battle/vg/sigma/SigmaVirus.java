package com.argentstew.simulator.battle.vg.sigma;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sigma
 * 8/24/2019
 *
 * @author Craig
 */
public class SigmaVirus extends RangedXStrike {

    public SigmaVirus() {
        super();
        this.name = "Sigma Virus";
        this.power = 160;
        this.variance = 10;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.THUNDER, AttackSubType.TOXIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return defender.getClassifications().contains(FighterClassification.MECH) ? 1 : super.getCritChance(defender);
    }
}
