package com.argentstew.simulator.battle.vg.diablo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diablo
 * 8/27/2019
 *
 * @author Craig
 */
public class Apocalypse extends RangedAttack {

    public Apocalypse() {
        super();
        this.name = "Apocalypse";
        this.power = 70;
        this.variance = 7;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }
}
