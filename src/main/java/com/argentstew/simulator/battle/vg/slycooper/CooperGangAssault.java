package com.argentstew.simulator.battle.vg.slycooper;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sly
 * 8/24/2019
 *
 * @author Craig
 */
public class CooperGangAssault extends MeleeXStrike {

    public CooperGangAssault() {
        super();
        this.name = "Cooper Gang Assault";
        this.power = 230;
        this.variance = 15;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.SMASH, AttackSubType.ASSIST);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
