package com.argentstew.simulator.battle.vg.mbison;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mbison
 * 8/24/2019
 *
 * @author Craig
 */
public class DoubleKneePress extends MeleeAttack {

    public DoubleKneePress() {
        super();
        this.name = "Double Knee Press";
        this.power = 60;
        this.variance = 12;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
