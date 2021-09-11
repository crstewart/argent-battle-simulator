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
public class PlanetaryRing extends MagicAttack {

    public PlanetaryRing() {
        super();
        this.name = "Planetary Ring";
        this.power = 40;
        this.variance = 4;
        this.speed = 1;
        this.requiresMeleeRange = true;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
    }
}
