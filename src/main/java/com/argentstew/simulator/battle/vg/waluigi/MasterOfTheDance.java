package com.argentstew.simulator.battle.vg.waluigi;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.waluigi
 * 8/27/2019
 *
 * @author Craig
 */
public class MasterOfTheDance extends MeleeXStrike {

    public MasterOfTheDance() {
        super();
        this.name = "Master of the Dance";
        this.power = 260;
        this.variance = 12;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.KICK, AttackSubType.MYSTIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
