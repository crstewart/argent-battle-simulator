package com.argentstew.simulator.battle.vg.captfalcon;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.captfalcon
 * 8/27/2019
 *
 * @author Craig
 */
public class RaptorBoost extends MeleeAttack {

    public RaptorBoost() {
        super();
        this.name = "Raptor Boost";
        this.power = 40;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
