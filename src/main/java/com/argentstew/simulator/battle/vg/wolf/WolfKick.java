package com.argentstew.simulator.battle.vg.wolf;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wolf
 * 8/24/2019
 *
 * @author Craig
 */
public class WolfKick extends MeleeAttack {

    public WolfKick() {
        super();
        this.name = "Wolf Kick";
        this.power = 80;
        this.variance = 8;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
