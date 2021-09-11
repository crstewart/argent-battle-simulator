package com.argentstew.simulator.battle.vg.terra;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terra
 * 8/27/2019
 *
 * @author Craig
 */
public class TranceUltima extends MagicXStrike {

    public TranceUltima() {
        super();
        this.name = "Trance Ultima";
        this.power = 320;
        this.variance = 15;
        this.speed = 8;
        this.subtypes = Collections.emptyList();
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
