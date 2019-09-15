package com.argentstew.simulator.battle.vg.mewtwo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mewtwo
 * 9/15/2019
 *
 * @author Craig
 */
public class ShadowBall extends RangedAttack {

    public ShadowBall() {
        super();
        this.name = "Shadow Ball";
        this.power = 80;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }
}
