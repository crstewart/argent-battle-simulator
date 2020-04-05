package com.argentstew.simulator.battle.vg.scorpion;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.scorpion
 * 8/24/2019
 *
 * @author Craig
 */
public class Toasty extends MeleeXStrike {

    public Toasty() {
        super();
        this.name = "Toasty!";
        this.power = 160;
        this.variance = 12;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 0.5;
    }
}
