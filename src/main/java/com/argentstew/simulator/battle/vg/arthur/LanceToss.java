package com.argentstew.simulator.battle.vg.arthur;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.arthur
 * 8/24/2019
 *
 * @author Craig
 */
public class LanceToss extends RangedAttack {

    public LanceToss() {
        super();
        this.name = "Lance Toss";
        this.power = 70;
        this.variance = 7;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
