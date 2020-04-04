package com.argentstew.simulator.battle.vg.terry;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terry
 * 8/24/2019
 *
 * @author Craig
 */
public class BurningKnuckle extends MeleeAttack {

    public BurningKnuckle() {
        super();
        this.name = "Burning Knuckle";
        this.power = 50;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
