package com.argentstew.simulator.battle.vg.banjo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.banjo
 * 9/8/2019
 *
 * @author Craig
 */
public class ForwardRoll extends MeleeAttack {

    public ForwardRoll() {
        super();
        this.name = "Forward Roll";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
