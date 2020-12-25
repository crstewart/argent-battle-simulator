package com.argentstew.simulator.battle.vg.bomberman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bomberman
 * 8/27/2019
 *
 * @author Craig
 */
public class WindBomb extends RangedAttack {

    public WindBomb() {
        super();
        this.name = "Wind Bomb";
        this.power = 55;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.AIR, AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
