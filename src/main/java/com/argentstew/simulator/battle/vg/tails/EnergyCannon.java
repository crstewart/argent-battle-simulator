package com.argentstew.simulator.battle.vg.tails;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tails
 * 8/26/2019
 *
 * @author Craig
 */
public class EnergyCannon extends RangedAttack {

    public EnergyCannon() {
        super();
        this.name = "Energy Cannon";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }
}
