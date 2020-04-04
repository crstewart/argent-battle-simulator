package com.argentstew.simulator.battle.vg.bigdaddy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bigdaddy
 * 8/27/2019
 *
 * @author Craig
 */
public class Charge extends MeleeAttack {

    public Charge() {
        super();
        this.name = "Charge";
        this.power = 45;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
