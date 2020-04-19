package com.argentstew.simulator.battle.vg.niko;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.niko
 * 8/24/2019
 *
 * @author Craig
 */
public class Remington700 extends RangedXStrike {

    public Remington700() {
        super();
        this.name = "Remington 700";
        this.description = "Always critical hits";
        this.power = 150;
        this.variance = 10;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 1;
    }
}
