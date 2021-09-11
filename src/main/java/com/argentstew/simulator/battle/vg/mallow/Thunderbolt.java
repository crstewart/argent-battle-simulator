package com.argentstew.simulator.battle.vg.mallow;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mallow
 * 8/27/2019
 *
 * @author Craig
 */
public class Thunderbolt extends MagicAttack {

    public Thunderbolt() {
        super();
        this.name = "Thunderbolt";
        this.power = 40;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
