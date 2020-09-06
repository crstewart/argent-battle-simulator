package com.argentstew.simulator.battle.vg.viewtifuljoe;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.viewtifuljoe
 * 8/24/2019
 *
 * @author Craig
 */
public class ShockingPink extends RangedAttack {

    public ShockingPink() {
        super();
        this.name = "Shocking Pink";
        this.power = 65;
        this.variance = 6;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
