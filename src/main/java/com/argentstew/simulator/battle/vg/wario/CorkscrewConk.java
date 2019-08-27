package com.argentstew.simulator.battle.vg.wario;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wario
 * 8/27/2019
 *
 * @author Craig
 */
public class CorkscrewConk extends MeleeAttack {

    public CorkscrewConk() {
        super();
        this.name = "Corkscrew Conk";
        this.power = 50;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HEADBUTT);
        this.characteristics = Collections.emptyList();
    }
}
