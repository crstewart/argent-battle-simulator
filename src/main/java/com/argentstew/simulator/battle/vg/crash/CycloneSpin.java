package com.argentstew.simulator.battle.vg.crash;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.crash
 * 8/27/2019
 *
 * @author Craig
 */
public class CycloneSpin extends MeleeAttack {

    public CycloneSpin() {
        super();
        this.name = "Cyclone Spin";
        this.power = 65;
        this.variance = 12;
        this.speed = 0.5;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
