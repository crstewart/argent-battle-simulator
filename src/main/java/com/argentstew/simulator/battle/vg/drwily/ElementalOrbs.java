package com.argentstew.simulator.battle.vg.drwily;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.drwily
 * 8/27/2019
 *
 * @author Craig
 */
public class ElementalOrbs extends RangedAttack {

    public ElementalOrbs() {
        super();
        this.name = "Elemental Orbs";
        this.power = 55;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.FIRE, AttackSubType.ICE, AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
