package com.argentstew.simulator.battle.vg.yoshi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.yoshi
 * 8/26/2019
 *
 * @author Craig
 */
public class GroundPound extends MeleeAttack {

    public GroundPound() {
        super();
        this.name = "Ground Pound";
        this.power = 70;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
