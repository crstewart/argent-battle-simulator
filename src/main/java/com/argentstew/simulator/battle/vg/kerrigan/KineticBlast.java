package com.argentstew.simulator.battle.vg.kerrigan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kerrigan
 * 8/24/2019
 *
 * @author Craig
 */
public class KineticBlast extends RangedAttack {

    public KineticBlast() {
        super();
        this.name = "Kinetic Blast";
        this.power = 60;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }
}
