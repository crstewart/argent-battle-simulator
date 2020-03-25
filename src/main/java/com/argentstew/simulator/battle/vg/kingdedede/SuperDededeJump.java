package com.argentstew.simulator.battle.vg.kingdedede;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kingdedede
 * 8/24/2019
 *
 * @author Craig
 */
public class SuperDededeJump extends MeleeAttack {

    public SuperDededeJump() {
        super();
        this.name = "Super Dedede Jump";
        this.power = 90;
        this.variance = 6;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
