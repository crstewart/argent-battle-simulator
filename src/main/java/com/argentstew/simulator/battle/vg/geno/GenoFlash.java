package com.argentstew.simulator.battle.vg.geno;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.geno
 * 8/24/2019
 *
 * @author Craig
 */
public class GenoFlash extends MagicXStrike {

    public GenoFlash() {
        super();
        this.name = "Geno Flash";
        this.power = 320;
        this.variance = 15;
        this.speed = 6;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
