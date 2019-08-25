package com.argentstew.simulator.battle.vg.mario;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class Fludd extends RangedAttack {

    public Fludd() {
        super();
        this.name = "F.L.U.D.D.";
        this.power = 40;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.WATER);
        this.characteristics = Collections.emptyList();
    }
}
