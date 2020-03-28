package com.argentstew.simulator.battle.vg.chunli;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.chunli
 * 8/24/2019
 *
 * @author Craig
 */
public class Koshuto extends MeleeAttack {

    public Koshuto() {
        super();
        this.name = "Koshuto";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
