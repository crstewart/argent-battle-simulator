package com.argentstew.simulator.battle.vg.nathandrake;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.nathandrake
 * 8/24/2019
 *
 * @author Craig
 */
public class EddysGoldenGun extends RangedXStrike {

    public EddysGoldenGun() {
        super();
        this.name = "Eddy's Golden Gun";
        this.power = 200;
        this.variance = 20;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
