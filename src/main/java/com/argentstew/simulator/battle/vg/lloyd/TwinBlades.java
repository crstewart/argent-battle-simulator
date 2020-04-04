package com.argentstew.simulator.battle.vg.lloyd;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.lloyd
 * 8/27/2019
 *
 * @author Craig
 */
public class TwinBlades extends MeleeAttack {

    public TwinBlades() {
        super();
        this.name = "Twin Blades";
        this.power = 60;
        this.variance = 4;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
