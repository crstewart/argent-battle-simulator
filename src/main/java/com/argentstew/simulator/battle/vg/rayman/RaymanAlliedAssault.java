package com.argentstew.simulator.battle.vg.rayman;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rayman
 * 8/24/2019
 *
 * @author Craig
 */
public class RaymanAlliedAssault extends MeleeXStrike {

    public RaymanAlliedAssault() {
        super();
        this.name = "Rayman Allied Assault";
        this.power = 250;
        this.variance = 20;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.HACK, AttackSubType.SLAM, AttackSubType.PUNCH, AttackSubType.ASSIST);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
