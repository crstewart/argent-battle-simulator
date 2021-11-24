package com.argentstew.simulator.battle.vg.alduin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.alduin
 * 8/27/2019
 *
 * @author Craig
 */
public class FrostBreath extends RangedAttack {

    public FrostBreath() {
        super();
        this.name = "Frost Breath (Fo Krah Diin)";
        this.power = 90;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Collections.emptyList();
    }
}
