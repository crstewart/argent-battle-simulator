package com.argentstew.simulator.battle.vg.rathalos;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rathalos
 * 8/24/2019
 *
 * @author Craig
 */
public class ExplosiveFireballs extends RangedXStrike {

    public ExplosiveFireballs() {
        super();
        this.name = "Explosive Fireballs";
        this.power = 280;
        this.variance = 18;
        this.speed = 6;
        this.subtypes = Arrays.asList(AttackSubType.EXPLOSIVE, AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
