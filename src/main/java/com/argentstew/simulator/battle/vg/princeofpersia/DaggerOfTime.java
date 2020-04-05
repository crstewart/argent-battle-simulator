package com.argentstew.simulator.battle.vg.princeofpersia;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.princeofpersia
 * 8/27/2019
 *
 * @author Craig
 */
public class DaggerOfTime extends MeleeAttack {

    public DaggerOfTime() {
        super();
        this.name = "Dagger of Time";
        this.power = 50;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
