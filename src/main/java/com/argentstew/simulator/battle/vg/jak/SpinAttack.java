package com.argentstew.simulator.battle.vg.jak;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.spyro
 * 8/27/2019
 *
 * @author Craig
 */
public class SpinAttack extends MeleeAttack {

    public SpinAttack() {
        super();
        this.name = "Spin Attack";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
