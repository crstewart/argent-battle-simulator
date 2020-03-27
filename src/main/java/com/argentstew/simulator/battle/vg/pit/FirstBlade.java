package com.argentstew.simulator.battle.vg.pit;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pit
 * 8/27/2019
 *
 * @author Craig
 */
public class FirstBlade extends MeleeAttack {

    public FirstBlade() {
        super();
        this.name = "First Blade";
        this.power = 60;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
