package com.argentstew.simulator.battle.vg.bowserjr;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bowserjr
 * 8/24/2019
 *
 * @author Craig
 */
public class Mechakoopa extends RangedAttack {

    public Mechakoopa() {
        super();
        this.name = "Mechakoopa";
        this.power = 55;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
