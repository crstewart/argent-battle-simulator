package com.argentstew.simulator.battle.vg.masterchief;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.masterchief
 * 8/24/2019
 *
 * @author Craig
 */
public class PlasmaPistolCharged extends RangedAttack {

    public PlasmaPistolCharged() {
        super();
        this.name = "Plasma Pistol (Charged)";
        this.power = 70;
        this.variance = 7;
        this.speed = 3.5;
        this.subtypes = Arrays.asList(AttackSubType.PLASMA, AttackSubType.ARMOR_PIERCING);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOMING);
    }
}
