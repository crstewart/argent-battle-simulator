package com.argentstew.simulator.battle.vg.kerrigan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kerrigan
 * 8/24/2019
 *
 * @author Craig
 */
public class LeapingStrike extends MeleeAttack {

    public LeapingStrike() {
        super();
        this.name = "Leaping Strike";
        this.power = 55;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
