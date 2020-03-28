package com.argentstew.simulator.battle.vg.zero;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.zero
 * 8/27/2019
 *
 * @author Craig
 */
public class ZeroBlaster extends RangedAttack {

    public ZeroBlaster() {
        super();
        this.name = "Zero Blaster";
        this.power = 50;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }
}
