package com.argentstew.simulator.battle.vg.samus;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samus
 * 11/10/2019
 *
 * @author Craig
 */
public class ChargeBeamFull extends RangedAttack {

    public ChargeBeamFull() {
        super();
        this.name = "Power Beam (Charged)";
        this.power = 90;
        this.variance = 5;
        this.speed = 5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }
}
