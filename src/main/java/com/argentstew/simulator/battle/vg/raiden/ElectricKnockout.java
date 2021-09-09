package com.argentstew.simulator.battle.vg.raiden;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.raiden
 * 8/24/2019
 *
 * @author Craig
 */
public class ElectricKnockout extends MeleeXStrike {

    public ElectricKnockout() {
        super();
        this.name = "Electric Knockout";
        this.description = "Has 50% critical hit chance";
        this.power = 170;
        this.variance = 10;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 0.5;
    }
}
