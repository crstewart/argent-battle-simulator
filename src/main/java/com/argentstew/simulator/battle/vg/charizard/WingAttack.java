package com.argentstew.simulator.battle.vg.charizard;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.charizard
 * 9/8/2019
 *
 * @author Craig
 */
public class WingAttack extends MeleeAttack {

    public WingAttack() {
        super();
        this.name = "Wing Attack";
        this.power = 60;
        this.variance = 6;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
        this.characteristics = Collections.emptyList();
    }
}
