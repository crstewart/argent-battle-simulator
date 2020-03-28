package com.argentstew.simulator.battle.vg.arthur;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.arthur
 * 8/24/2019
 *
 * @author Craig
 */
public class AxeToss extends RangedAttack {

    public AxeToss() {
        super();
        this.name = "Axe Toss";
        this.power = 80;
        this.variance = 8;
        this.speed = 3.5;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
