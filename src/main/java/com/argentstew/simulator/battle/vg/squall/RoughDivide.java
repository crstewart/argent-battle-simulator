package com.argentstew.simulator.battle.vg.squall;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.squall
 * 8/27/2019
 *
 * @author Craig
 */
public class RoughDivide extends MeleeAttack {

    public RoughDivide() {
        super();
        this.name = "Revolver";
        this.power = 75;
        this.variance = 7;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
