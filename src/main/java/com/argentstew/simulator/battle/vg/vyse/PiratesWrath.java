package com.argentstew.simulator.battle.vg.vyse;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.vyse
 * 8/24/2019
 *
 * @author Craig
 */
public class PiratesWrath extends MeleeXStrike {

    public PiratesWrath() {
        super();
        this.name = "Pirate's Wrath";
        this.power = 240;
        this.variance = 14;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.THUNDER);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double calculateSpeed() {
        return this.speed;
    }
}
