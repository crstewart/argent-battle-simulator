package com.argentstew.simulator.battle.vg.sylvanas;

import com.argentstew.simulator.battle.action.attack.*;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sylvanas
 * 8/24/2019
 *
 * @author Craig
 */
public class TouchOfDeath extends MagicXStrike {

    public TouchOfDeath() {
        super();
        this.name = "Touch of Death";
        this.description = "Has 50% critical hit chance";
        this.power = 200;
        this.variance = 10;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 0.5;
    }
}
