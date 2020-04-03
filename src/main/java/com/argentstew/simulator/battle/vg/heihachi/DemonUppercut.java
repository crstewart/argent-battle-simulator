package com.argentstew.simulator.battle.vg.heihachi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.heihachi
 * 8/24/2019
 *
 * @author Craig
 */
public class DemonUppercut extends MeleeAttack {

    public DemonUppercut() {
        super();
        this.name = "Demon Uppercut";
        this.power = 50;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
