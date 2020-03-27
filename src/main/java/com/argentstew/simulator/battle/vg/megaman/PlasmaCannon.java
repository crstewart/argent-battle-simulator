package com.argentstew.simulator.battle.vg.megaman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.megaman
 * 8/24/2019
 *
 * @author Craig
 */
public class PlasmaCannon extends RangedAttack {

    public PlasmaCannon() {
        super();
        this.name = "Plasma Cannon";
        this.power = 20;
        this.variance = 3;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }
}
