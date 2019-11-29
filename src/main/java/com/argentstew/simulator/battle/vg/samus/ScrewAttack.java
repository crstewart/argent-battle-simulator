package com.argentstew.simulator.battle.vg.samus;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samus
 * 11/10/2019
 *
 * @author Craig
 */
public class ScrewAttack extends MeleeAttack {

    public ScrewAttack() {
        super();
        this.name = "Screw Attack";
        this.power = 80;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
