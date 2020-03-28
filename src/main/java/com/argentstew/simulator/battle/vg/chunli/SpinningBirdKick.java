package com.argentstew.simulator.battle.vg.chunli;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.chunli
 * 8/24/2019
 *
 * @author Craig
 */
public class SpinningBirdKick extends MeleeAttack {

    public SpinningBirdKick() {
        super();
        this.name = "Spinning Bird Kick";
        this.power = 70;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
