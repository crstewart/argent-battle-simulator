package com.argentstew.simulator.battle.vg.cole;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cole
 * 8/27/2019
 *
 * @author Craig
 */
public class ShockGrenade extends RangedAttack {

    public ShockGrenade() {
        super();
        this.name = "Shock Grenade";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.EXPLOSIVE, AttackSubType.THUNDER);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
