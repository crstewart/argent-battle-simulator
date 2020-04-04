package com.argentstew.simulator.battle.vg.steve;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.steve
 * 8/27/2019
 *
 * @author Craig
 */
public class Pickaxe extends MeleeAttack {

    public Pickaxe() {
        super();
        this.name = "Pick-axe";
        this.power = 60;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
