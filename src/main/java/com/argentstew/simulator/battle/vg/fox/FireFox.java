package com.argentstew.simulator.battle.vg.fox;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.fox
 * 8/24/2019
 *
 * @author Craig
 */
public class FireFox extends MeleeAttack {

    public FireFox() {
        super();
        this.name = "Fire Fox";
        this.power = 90;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
