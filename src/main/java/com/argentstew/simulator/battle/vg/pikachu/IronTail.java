package com.argentstew.simulator.battle.vg.pikachu;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 9/7/2019
 *
 * @author Craig
 */
public class IronTail extends MeleeAttack {

    public IronTail() {
        super();
        this.name = "Iron Tail";
        this.power = 100;
        this.variance = 7;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.TAIL);
        this.characteristics = Collections.emptyList();
    }
}
