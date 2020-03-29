package com.argentstew.simulator.battle.vg.tails;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tails
 * 8/27/2019
 *
 * @author Craig
 */
public class PropellerDash extends MeleeAttack {

    public PropellerDash() {
        super();
        this.name = "Propeller Dash";
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
