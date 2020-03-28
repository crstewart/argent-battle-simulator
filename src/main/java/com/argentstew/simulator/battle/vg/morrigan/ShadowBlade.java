package com.argentstew.simulator.battle.vg.morrigan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.morrigan
 * 8/27/2019
 *
 * @author Craig
 */
public class ShadowBlade extends MeleeAttack {

    public ShadowBlade() {
        super();
        this.name = "Shadow Blade";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.WING);
        this.characteristics = Collections.emptyList();
    }
}
