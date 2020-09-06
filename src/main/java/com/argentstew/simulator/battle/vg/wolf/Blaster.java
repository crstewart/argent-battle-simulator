package com.argentstew.simulator.battle.vg.wolf;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wolf
 * 8/24/2019
 *
 * @author Craig
 */
public class Blaster extends RangedAttack {

    public Blaster() {
        super();
        this.name = "Blaster";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }
}
