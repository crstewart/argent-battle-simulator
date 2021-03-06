package com.argentstew.simulator.battle.vg.princeofpersia;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.princeofpersia
 * 8/24/2019
 *
 * @author Craig
 */
public class PowerOfTheDjinn extends MagicXStrike {

    public PowerOfTheDjinn() {
        super();
        this.name = "Power of the Djinn";
        this.power = 260;
        this.variance = 20;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.FIRE, AttackSubType.ICE, AttackSubType.AIR, AttackSubType.EARTH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
