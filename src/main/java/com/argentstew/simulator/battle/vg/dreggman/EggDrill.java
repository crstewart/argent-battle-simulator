package com.argentstew.simulator.battle.vg.dreggman;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dreggman
 * 8/27/2019
 *
 * @author Craig
 */
public class EggDrill extends MeleeAttack {

    public EggDrill() {
        super();
        this.name = "Egg Drill";
        this.power = 85;
        this.variance = 8;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
