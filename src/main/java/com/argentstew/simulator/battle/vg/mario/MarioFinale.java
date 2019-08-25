package com.argentstew.simulator.battle.vg.mario;

import com.argentstew.simulator.battle.action.attack.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class MarioFinale extends RangedXStrike {

    public MarioFinale() {
        super();
        this.name = "Mario Finale";
        this.power = 140;
        this.variance = 14;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}