package com.argentstew.simulator.battle.vg.marcusfenix;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.marcusfenix
 * 8/24/2019
 *
 * @author Craig
 */
public class HammerOfDawn extends RangedXStrike {

    public HammerOfDawn() {
        super();
        this.name = "Hammer of Dawn";
        this.power = 250;
        this.variance = 15;
        this.speed = 8;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
