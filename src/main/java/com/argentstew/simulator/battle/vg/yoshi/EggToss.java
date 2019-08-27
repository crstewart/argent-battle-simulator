package com.argentstew.simulator.battle.vg.yoshi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.yoshi
 * 8/26/2019
 *
 * @author Craig
 */
public class EggToss extends RangedAttack {

    public EggToss() {
        super();
        this.name = "Egg Toss";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.NATURE);
        this.characteristics = Collections.emptyList();
    }
}
