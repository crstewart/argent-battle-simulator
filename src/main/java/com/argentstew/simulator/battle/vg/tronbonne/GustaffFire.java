package com.argentstew.simulator.battle.vg.tronbonne;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tronbonne
 * 8/24/2019
 *
 * @author Craig
 */
public class GustaffFire extends RangedAttack {

    public GustaffFire() {
        super();
        this.name = "Gustaff Fire";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
