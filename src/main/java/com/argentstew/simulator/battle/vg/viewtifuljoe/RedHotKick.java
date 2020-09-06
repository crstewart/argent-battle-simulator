package com.argentstew.simulator.battle.vg.viewtifuljoe;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.viewtifuljoe
 * 8/24/2019
 *
 * @author Craig
 */
public class RedHotKick extends MeleeAttack {

    public RedHotKick() {
        super();
        this.name = "Red Hot Kick";
        this.power = 55;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.KICK, AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
