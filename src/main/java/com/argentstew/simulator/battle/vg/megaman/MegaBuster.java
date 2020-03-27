package com.argentstew.simulator.battle.vg.megaman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.megaman
 * 8/24/2019
 *
 * @author Craig
 */
public class MegaBuster extends RangedAttack {

    public MegaBuster() {
        super();
        this.name = "Mega Buster";
        this.power = 60;
        this.variance = 6;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }
}
