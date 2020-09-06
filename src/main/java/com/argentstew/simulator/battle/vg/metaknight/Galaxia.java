package com.argentstew.simulator.battle.vg.metaknight;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.metaknight
 * 8/24/2019
 *
 * @author Craig
 */
public class Galaxia extends MeleeAttack {

    public Galaxia() {
        super();
        this.name = "Galaxia";
        this.power = 50;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
