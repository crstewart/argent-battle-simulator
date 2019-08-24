package com.argentstew.simulator.battle.vg.bowser;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bowser
 * 8/24/2019
 *
 * @author Craig
 */
public class FireBreath extends RangedAttack {

    public FireBreath() {
        super();
        this.name = "Fire Breath";
        this.power = 35;
        this.variance = 7;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
