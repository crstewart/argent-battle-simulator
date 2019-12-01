package com.argentstew.simulator.battle.vg.fox;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.fox
 * 8/24/2019
 *
 * @author Craig
 */
public class ArwingAssault extends RangedXStrike {

    public ArwingAssault() {
        super();
        this.name = "Arwing Assault";
        this.power = 250;
        this.variance = 14;
        this.speed = 3.5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
