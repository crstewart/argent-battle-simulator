package com.argentstew.simulator.battle.vg.raiden;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.raiden
 * 8/27/2019
 *
 * @author Craig
 */
public class LightningBolt extends RangedAttack {

    public LightningBolt() {
        super();
        this.name = "Lightning Bolt";
        this.power = 50;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
