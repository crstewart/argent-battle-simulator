package com.argentstew.simulator.battle.vg.chunli;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryu
 * 8/24/2019
 *
 * @author Craig
 */
public class Kikoken extends RangedAttack {

    public Kikoken() {
        super();
        this.name = "Kikoken";
        this.power = 50;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.CHI);
        this.characteristics = Collections.emptyList();
    }
}
