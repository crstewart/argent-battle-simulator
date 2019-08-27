package com.argentstew.simulator.battle.vg.donkeykong;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.donkeykong
 * 8/26/2019
 *
 * @author Craig
 */
public class HandSlap extends MeleeAttack {

    public HandSlap() {
        super();
        this.name = "Hand Slap";
        this.power = 60;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }
}
