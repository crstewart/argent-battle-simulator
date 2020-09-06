package com.argentstew.simulator.battle.vg.metaknight;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.metaknight
 * 8/24/2019
 *
 * @author Craig
 */
public class GalaxiaDarkness extends MeleeXStrike {

    public GalaxiaDarkness() {
        super();
        this.name = "Galaxia Darkness";
        this.power = 220;
        this.variance = 14;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
