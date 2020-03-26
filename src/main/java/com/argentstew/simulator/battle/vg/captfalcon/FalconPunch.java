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
public class FalconPunch extends MeleeAttack {

    public FalconPunch() {
        super();
        this.name = "Falcon Punch";
        this.power = 90;
        this.variance = 7;
        this.speed = 5;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
