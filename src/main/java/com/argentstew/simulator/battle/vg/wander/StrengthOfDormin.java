package com.argentstew.simulator.battle.vg.wander;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.wander
 * 8/27/2019
 *
 * @author Craig
 */
public class StrengthOfDormin extends MeleeXStrike {

    public StrengthOfDormin() {
        super();
        this.name = "Strength of Dormin";
        this.power = 300;
        this.variance = 15;
        this.speed = 6;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
