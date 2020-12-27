package com.argentstew.simulator.battle.vg.sans;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sans
 * 8/27/2019
 *
 * @author Craig
 */
public class BlueAttack extends MagicAttack {

    public BlueAttack() {
        super();
        this.name = "Blue Attack";
        this.power = 70;
        this.variance = 7;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }
}
