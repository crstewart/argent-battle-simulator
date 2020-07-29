package com.argentstew.simulator.battle.vg.albertwesker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.albertwesker
 * 8/24/2019
 *
 * @author Craig
 */
public class LostInNightmares extends MeleeXStrike {

    public LostInNightmares() {
        super();
        this.name = "Lost in Nightmares";
        this.power = 250;
        this.variance = 15;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.EXPLOSIVE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
