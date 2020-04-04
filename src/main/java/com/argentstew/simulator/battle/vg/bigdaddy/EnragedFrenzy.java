package com.argentstew.simulator.battle.vg.bigdaddy;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.bigdaddy
 * 8/24/2019
 *
 * @author Craig
 */
public class EnragedFrenzy extends MeleeXStrike {

    public EnragedFrenzy() {
        super();
        this.name = "Enraged Frenzy";
        this.power = 240;
        this.variance = 18;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.PIERCE, AttackSubType.ARMOR_PIERCING);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNDODGEABLE, AttackCharacteristic.UNGUARDABLE);
    }
}
