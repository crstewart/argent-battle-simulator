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
public class FireBomb extends RangedAttack {

    public FireBomb() {
        super();
        this.name = "Fire Bomb";
        this.power = 50;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.FIRE, AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
