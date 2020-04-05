package com.argentstew.simulator.battle.vg.ryuhayabusa;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sly
 * 8/24/2019
 *
 * @author Craig
 */
public class EyeOfTheDragon extends MeleeXStrike {

    public EyeOfTheDragon() {
        super();
        this.name = "Eye of the Dragon";
        this.power = 240;
        this.variance = 14;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
