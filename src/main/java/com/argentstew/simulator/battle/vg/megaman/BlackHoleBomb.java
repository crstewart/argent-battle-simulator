package com.argentstew.simulator.battle.vg.megaman;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class BlackHoleBomb extends RangedXStrike {

    public BlackHoleBomb() {
        super();
        this.name = "Black Hole Bomb";
        this.power = 250;
        this.variance = 15;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.GRAVITY);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
