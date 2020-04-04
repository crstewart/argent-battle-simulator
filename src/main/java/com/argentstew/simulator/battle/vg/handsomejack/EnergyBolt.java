package com.argentstew.simulator.battle.vg.handsomejack;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.handsomejack
 * 8/27/2019
 *
 * @author Craig
 */
public class EnergyBolt extends RangedAttack {

    public EnergyBolt() {
        super();
        this.name = "Energy Bolt";
        this.power = 50;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }
}
