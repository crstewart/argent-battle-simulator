package com.argentstew.simulator.battle.vg.shadow;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shadow
 * 8/27/2019
 *
 * @author Craig
 */
public class ChaosControl extends RangedAttack {

    public ChaosControl() {
        super();
        this.name = "Chaos Control";
        this.power = 45;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
