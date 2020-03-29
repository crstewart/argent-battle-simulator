package com.argentstew.simulator.battle.vg.tails;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tails
 * 8/24/2019
 *
 * @author Craig
 */
public class TornadoMechRaid extends RangedXStrike {

    public TornadoMechRaid() {
        super();
        this.name = "Tornado Mech Raid";
        this.power = 250;
        this.variance = 16;
        this.speed = 5;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double calculateSpeed() {
        return this.speed;
    }
}
