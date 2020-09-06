package com.argentstew.simulator.battle.vg.aloy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.aloy
 * 8/24/2019
 *
 * @author Craig
 */
public class Spear extends MeleeAttack {

    public Spear() {
        super();
        this.name = "Spear";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
