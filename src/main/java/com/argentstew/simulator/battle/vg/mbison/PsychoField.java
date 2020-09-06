package com.argentstew.simulator.battle.vg.mbison;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mbison
 * 8/24/2019
 *
 * @author Craig
 */
public class PsychoField extends RangedAttack {

    public PsychoField() {
        super();
        this.name = "Psycho Field";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.MYSTIC);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
