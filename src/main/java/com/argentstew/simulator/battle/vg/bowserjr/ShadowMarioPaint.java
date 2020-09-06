package com.argentstew.simulator.battle.vg.bowserjr;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bowserjr
 * 8/24/2019
 *
 * @author Craig
 */
public class ShadowMarioPaint extends MeleeXStrike {

    public ShadowMarioPaint() {
        super();
        this.name = "Shadow Mario Paint";
        this.power = 240;
        this.variance = 14;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
