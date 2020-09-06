package com.argentstew.simulator.battle.vg.aloy;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.aloy
 * 8/24/2019
 *
 * @author Craig
 */
public class DeathbringerGun extends RangedXStrike {

    public DeathbringerGun() {
        super();
        this.name = "Deathbringer Gun";
        this.power = 230;
        this.variance = 12;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
