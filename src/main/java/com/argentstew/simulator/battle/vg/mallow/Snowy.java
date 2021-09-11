package com.argentstew.simulator.battle.vg.mallow;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mallow
 * 8/27/2019
 *
 * @author Craig
 */
public class Snowy extends MagicAttack {

    public Snowy() {
        super();
        this.name = "Snowy";
        this.power = 60;
        this.variance = 12;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Collections.emptyList();
    }
}
