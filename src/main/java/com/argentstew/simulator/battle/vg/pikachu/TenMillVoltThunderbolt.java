package com.argentstew.simulator.battle.vg.pikachu;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 9/7/2019
 *
 * @author Craig
 */
public class TenMillVoltThunderbolt extends RangedXStrike {

    public TenMillVoltThunderbolt() {
        super();
        this.name = "10,000,000 Volt Thunderbolt";
        this.power = 250;
        this.variance = 25;
        this.speed = 6;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
