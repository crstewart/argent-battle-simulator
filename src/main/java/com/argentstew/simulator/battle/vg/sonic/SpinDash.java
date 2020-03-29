package com.argentstew.simulator.battle.vg.sonic;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sonic
 * 8/27/2019
 *
 * @author Craig
 */
public class SpinDash extends MeleeAttack {

    public SpinDash() {
        super();
        this.name = "Spin Dash";
        this.power = 45;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double calculateSpeed() {
        return this.speed;
    }
}
