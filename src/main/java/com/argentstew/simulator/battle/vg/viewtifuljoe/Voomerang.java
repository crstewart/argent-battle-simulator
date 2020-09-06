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
public class Voomerang extends RangedAttack {

    public Voomerang() {
        super();
        this.name = "Voomerang";
        this.power = 50;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
