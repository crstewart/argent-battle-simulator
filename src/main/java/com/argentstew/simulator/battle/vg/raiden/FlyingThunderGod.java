package com.argentstew.simulator.battle.vg.raiden;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.raiden
 * 8/27/2019
 *
 * @author Craig
 */
public class FlyingThunderGod extends MeleeAttack {

    public FlyingThunderGod() {
        super();
        this.name = "Flying Thunder God";
        this.power = 70;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
