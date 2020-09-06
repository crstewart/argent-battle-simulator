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
public class MachTornado extends MeleeAttack {

    public MachTornado() {
        super();
        this.name = "Mach Tornado";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
        this.characteristics = Collections.emptyList();
    }
}
