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
public class Thundaga extends MagicAttack {

    public Thundaga() {
        super();
        this.name = "Thundaga";
        this.power = 60;
        this.variance = 12;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
