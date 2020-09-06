package com.argentstew.simulator.battle.vg.aloy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.aloy
 * 8/24/2019
 *
 * @author Craig
 */
public class SharpshotBow extends RangedAttack {

    public SharpshotBow() {
        super();
        this.name = "Sharpshot Bow";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
