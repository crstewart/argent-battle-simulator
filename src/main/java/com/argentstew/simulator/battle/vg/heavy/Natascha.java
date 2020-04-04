package com.argentstew.simulator.battle.vg.heavy;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.heavy
 * 8/24/2019
 *
 * @author Craig
 */
public class Natascha extends RangedXStrike {

    public Natascha() {
        super();
        this.name = "Natascha";
        this.power = 180;
        this.variance = 30;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
