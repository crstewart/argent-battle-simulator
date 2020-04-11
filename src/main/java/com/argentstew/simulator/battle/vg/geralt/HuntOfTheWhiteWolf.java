package com.argentstew.simulator.battle.vg.geralt;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.geralt
 * 8/27/2019
 *
 * @author Craig
 */
public class HuntOfTheWhiteWolf extends MeleeXStrike {

    public HuntOfTheWhiteWolf() {
        super();
        this.name = "Hunt of the White Wolf";
        this.power = 220;
        this.variance = 18;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
