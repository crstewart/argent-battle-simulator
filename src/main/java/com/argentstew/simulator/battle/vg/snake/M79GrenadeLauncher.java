package com.argentstew.simulator.battle.vg.snake;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.snake
 * 8/24/2019
 *
 * @author Craig
 */
public class M79GrenadeLauncher extends RangedXStrike {

    public M79GrenadeLauncher() {
        super();
        this.name = "M79 Grenade Launcher";
        this.power = 225;
        this.variance = 18;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
