package com.argentstew.simulator.battle.vg.pyramidhead;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pyramidhead
 * 8/27/2019
 *
 * @author Craig
 */
public class ChokeHold extends MeleeAttack {

    public ChokeHold() {
        super();
        this.name = "Choke Hold";
        this.power = 55;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }
}
