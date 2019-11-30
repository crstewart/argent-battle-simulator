package com.argentstew.simulator.battle.vg.ridley;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ridley
 * 9/15/2019
 *
 * @author Craig
 */
public class WingBlitz extends MeleeAttack {

    public WingBlitz() {
        super();
        this.name = "Wing Blitz";
        this.power = 75;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.WING);
        this.characteristics = Collections.emptyList();
    }
}
