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
public class FalconKick extends MeleeAttack {

    public FalconKick() {
        super();
        this.name = "Falcon Kick";
        this.power = 50;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.KICK, AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
