package com.argentstew.simulator.battle.vg.tyrael;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tyrael
 * 8/27/2019
 *
 * @author Craig
 */
public class Smite extends MagicAttack {

    public Smite() {
        super();
        this.name = "Smite";
        this.power = 50;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
        this.requiresMeleeRange = true;
    }
}
