package com.argentstew.simulator.battle.vg.bowser;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class KoopaClaw extends MeleeAttack {

    public KoopaClaw() {
        super();
        this.name = "Koopa Claw";
        this.power = 55;
        this.variance = 3;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.CLAW);
        this.characteristics = Collections.emptyList();
    }
}
