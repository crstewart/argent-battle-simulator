package com.argentstew.simulator.battle.vg.aloy;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.aloy
 * 8/24/2019
 *
 * @author Craig
 */
public class BlastSling extends RangedAttack {

    public BlastSling() {
        super();
        this.name = "Blast Sling";
        this.power = 45;
        this.variance = 4;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
    }
}
