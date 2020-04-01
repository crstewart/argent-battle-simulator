package com.argentstew.simulator.battle.vg.crash;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.crash
 * 8/27/2019
 *
 * @author Craig
 */
public class FruitBazooka extends RangedAttack {

    public FruitBazooka() {
        super();
        this.name = "Fruit Bazooka";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.NATURE);
        this.characteristics = Collections.emptyList();
    }
}
