package com.argentstew.simulator.battle.vg.guybrush;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.guybrush
 * 8/27/2019
 *
 * @author Craig
 */
public class Cutlass extends MeleeAttack {

    public Cutlass() {
        super();
        this.name = "Cutlass";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
