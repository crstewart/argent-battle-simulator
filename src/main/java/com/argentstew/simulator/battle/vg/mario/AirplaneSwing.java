package com.argentstew.simulator.battle.vg.mario;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class AirplaneSwing extends MeleeAttack {

    public AirplaneSwing() {
        super();
        this.name = "Airplane Swing";
        this.power = 60;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }
}
