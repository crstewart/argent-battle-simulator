package com.argentstew.simulator.battle.vg.ellie;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ellie
 * 8/24/2019
 *
 * @author Craig
 */
public class SilencedSubmachineGun extends RangedXStrike {

    public SilencedSubmachineGun() {
        super();
        this.name = "Silenced Submachine Gun";
        this.power = 200;
        this.variance = 25;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
