package com.argentstew.simulator.battle.vg.albertwesker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.albertwesker
 * 8/24/2019
 *
 * @author Craig
 */
public class JaguarDash extends MeleeAttack {

    public JaguarDash() {
        super();
        this.name = "Jaguar Dash";
        this.power = 55;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
