package com.argentstew.simulator.battle.vg.kosmos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kosmos
 * 8/24/2019
 *
 * @author Craig
 */
public class FScythe extends MeleeAttack {

    public FScythe() {
        super();
        this.name = "F-SCYTHE";
        this.power = 85;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
