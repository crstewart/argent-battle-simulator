package com.argentstew.simulator.battle.vg.rosalina;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.rosalina
 * 8/27/2019
 *
 * @author Craig
 */
public class GrandStar extends MagicXStrike {

    public GrandStar() {
        super();
        this.name = "Grand Star";
        this.power = 250;
        this.variance = 15;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.LIGHT, AttackSubType.EXPLOSIVE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
