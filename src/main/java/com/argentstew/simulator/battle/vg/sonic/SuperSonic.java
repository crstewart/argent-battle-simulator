package com.argentstew.simulator.battle.vg.sonic;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sonic
 * 8/24/2019
 *
 * @author Craig
 */
public class SuperSonic extends MeleeXStrike {

    public SuperSonic() {
        super();
        this.name = "Super Sonic";
        this.description = "No additional startup time";
        this.power = 230;
        this.variance = 15;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.LIGHT);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double calculateSpeed() {
        return this.speed;
    }
}
