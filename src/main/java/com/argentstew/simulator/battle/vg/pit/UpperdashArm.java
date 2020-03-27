package com.argentstew.simulator.battle.vg.pit;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pit
 * 8/27/2019
 *
 * @author Craig
 */
public class UpperdashArm extends MeleeAttack {

    public UpperdashArm() {
        super();
        this.name = "Upperdash Arm";
        this.power = 60;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
