package com.argentstew.simulator.battle.vg.sigma;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sigma
 * 8/27/2019
 *
 * @author Craig
 */
public class BeamSaber extends MeleeAttack {

    public BeamSaber() {
        super();
        this.name = "Beam Saber";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
