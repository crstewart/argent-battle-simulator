package com.argentstew.simulator.battle.vg.rosalina;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rosalina
 * 8/27/2019
 *
 * @author Craig
 */
public class GalaxyBlast extends MagicAttack {

    public GalaxyBlast() {
        super();
        this.name = "Galaxy Blast";
        this.power = 60;
        this.variance = 7;
        this.speed = 2;
        this.requiresMeleeRange = true;
        this.subtypes = Collections.singletonList(AttackSubType.GRAVITY);
        this.characteristics = Collections.emptyList();
    }
}
