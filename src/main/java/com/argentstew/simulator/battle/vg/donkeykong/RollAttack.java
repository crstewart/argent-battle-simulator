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
public class RollAttack extends MeleeAttack {

    public RollAttack() {
        super();
        this.name = "Roll Attack";
        this.power = 55;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
