package com.argentstew.simulator.battle.vg.kirby;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kirby
 * 8/24/2019
 *
 * @author Craig
 */
public class StoneSmash extends MeleeAttack {

    public StoneSmash() {
        super();
        this.name = "Stone Smash";
        this.power = 60;
        this.variance = 4;
        this.speed = 0;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }
}
