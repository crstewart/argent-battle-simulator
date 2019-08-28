package com.argentstew.simulator.battle.vg.zelda;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.zelda
 * 8/27/2019
 *
 * @author Craig
 */
public class ArrowOfLight extends MagicAttack {

    public ArrowOfLight() {
        super();
        this.name = "Arrow of Light";
        this.power = 90;
        this.variance = 9;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
    }
}
