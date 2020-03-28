package com.argentstew.simulator.battle.vg.zero;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.zero
 * 8/27/2019
 *
 * @author Craig
 */
public class ZSaber extends MeleeAttack {

    public ZSaber() {
        super();
        this.name = "Z-Saber";
        this.power = 55;
        this.variance = 6;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
