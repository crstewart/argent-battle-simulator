package com.argentstew.simulator.battle.vg.waluigi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.waluigi
 * 8/27/2019
 *
 * @author Craig
 */
public class TennisRacket extends MeleeAttack {

    public TennisRacket() {
        super();
        this.name = "Tennis Racket";
        this.power = 50;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
