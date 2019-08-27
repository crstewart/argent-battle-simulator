package com.argentstew.simulator.battle.vg.wario;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wario
 * 8/27/2019
 *
 * @author Craig
 */
public class ShoulderCharge extends MeleeAttack {

    public ShoulderCharge() {
        super();
        this.name = "Shoulder Charge";
        this.power = 65;
        this.variance = 8;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
