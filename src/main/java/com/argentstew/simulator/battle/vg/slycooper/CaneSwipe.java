package com.argentstew.simulator.battle.vg.slycooper;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sly
 * 8/27/2019
 *
 * @author Craig
 */
public class CaneSwipe extends MeleeAttack {

    public CaneSwipe() {
        super();
        this.name = "Cane Swipe";
        this.power = 50;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
