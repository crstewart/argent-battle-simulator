package com.argentstew.simulator.battle.vg.ness;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.peach
 * 8/24/2019
 *
 * @author Craig
 */
public class PkStarstorm extends RangedXStrike {

    public PkStarstorm() {
        super();
        this.name = "PK Starstorm";
        this.power = 260;
        this.variance = 17;
        this.speed = 2.5;
        this.subtypes = Arrays.asList(AttackSubType.MYSTIC, AttackSubType.ASSIST);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
