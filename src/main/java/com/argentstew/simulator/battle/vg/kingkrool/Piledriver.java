package com.argentstew.simulator.battle.vg.kingkrool;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kingkrool
 * 8/24/2019
 *
 * @author Craig
 */
public class Piledriver extends MeleeAttack {

    public Piledriver() {
        super();
        this.name = "Piledriver";
        this.power = 80;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
