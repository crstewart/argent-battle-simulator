package com.argentstew.simulator.battle.vg.dreggman;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dreggman
 * 8/27/2019
 *
 * @author Craig
 */
public class EggBomb extends RangedAttack {

    public EggBomb() {
        super();
        this.name = "Egg Bomb";
        this.power = 80;
        this.variance = 7;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
