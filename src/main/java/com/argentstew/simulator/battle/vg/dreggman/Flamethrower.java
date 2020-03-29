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
public class Flamethrower extends RangedAttack {

    public Flamethrower() {
        super();
        this.name = "Flamethrower";
        this.power = 60;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
