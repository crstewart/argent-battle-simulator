package com.argentstew.simulator.battle.vg.metaknight;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.metaknight
 * 8/24/2019
 *
 * @author Craig
 */
public class DimensionalCape extends MeleeAttack {

    public DimensionalCape() {
        super();
        this.name = "Dimensional Cape";
        this.power = 40;
        this.variance = 4;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
    }
}
