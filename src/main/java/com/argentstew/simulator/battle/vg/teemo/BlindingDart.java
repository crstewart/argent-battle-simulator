package com.argentstew.simulator.battle.vg.teemo;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.teemo
 * 8/27/2019
 *
 * @author Craig
 */
public class BlindingDart extends MagicAttack {

    public BlindingDart() {
        super();
        this.name = "Blinding Dart";
        this.power = 40;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
    }
}
