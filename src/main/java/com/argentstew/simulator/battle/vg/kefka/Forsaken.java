package com.argentstew.simulator.battle.vg.kefka;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kefka
 * 8/27/2019
 *
 * @author Craig
 */
public class Forsaken extends MagicAttack {

    public Forsaken() {
        super();
        this.name = "Forsaken";
        this.power = 50;
        this.variance = 10;
        this.speed = 2;
        this.subtypes = Collections.emptyList();
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
