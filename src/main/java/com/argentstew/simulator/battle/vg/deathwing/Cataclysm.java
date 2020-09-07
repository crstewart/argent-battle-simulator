package com.argentstew.simulator.battle.vg.deathwing;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.deathwing
 * 8/24/2019
 *
 * @author Craig
 */
public class Cataclysm extends RangedXStrike {

    public Cataclysm() {
        super();
        this.name = "Cataclysm";
        this.power = 270;
        this.variance = 10;
        this.speed = 8;
        this.subtypes = Arrays.asList(AttackSubType.EARTH, AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
