package com.argentstew.simulator.battle.vg.steve;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.steve
 * 8/27/2019
 *
 * @author Craig
 */
public class TNT extends RangedAttack {

    public TNT() {
        super();
        this.name = "TNT";
        this.power = 90;
        this.variance = 9;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
