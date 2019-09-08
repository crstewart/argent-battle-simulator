package com.argentstew.simulator.battle.vg.pikachu;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 9/7/2019
 *
 * @author Craig
 */
public class Thunderbolt extends RangedAttack {

    public Thunderbolt() {
        super();
        this.name = "Thunderbolt";
        this.power = 90;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
