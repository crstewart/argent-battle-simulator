package com.argentstew.simulator.battle.vg.tyrael;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tyrael
 * 8/27/2019
 *
 * @author Craig
 */
public class Eldruin extends MeleeAttack {

    public Eldruin() {
        super();
        this.name = "El'druin";
        this.power = 60;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.LIGHT, AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
