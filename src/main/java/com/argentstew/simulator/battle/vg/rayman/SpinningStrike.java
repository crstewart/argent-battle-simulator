package com.argentstew.simulator.battle.vg.rayman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rayman
 * 8/24/2019
 *
 * @author Craig
 */
public class SpinningStrike extends MeleeAttack {

    public SpinningStrike() {
        super();
        this.name = "Spinning Strike";
        this.power = 70;
        this.variance = 7;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
