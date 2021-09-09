package com.argentstew.simulator.battle.vg.amaterasu;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.amaterasu
 * 8/24/2019
 *
 * @author Craig
 */
public class CherryBomb extends RangedAttack {

    public CherryBomb() {
        super();
        this.name = "Cherry Bomb";
        this.power = 90;
        this.variance = 14;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
