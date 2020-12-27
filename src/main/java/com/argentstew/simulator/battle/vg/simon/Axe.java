package com.argentstew.simulator.battle.vg.simon;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.simon
 * 8/27/2019
 *
 * @author Craig
 */
public class Axe extends RangedAttack {

    public Axe() {
        super();
        this.name = "Axe";
        this.power = 80;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
