package com.argentstew.simulator.battle.vg.fox;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.fox
 * 8/24/2019
 *
 * @author Craig
 */
public class FoxIllusion extends MeleeAttack {

    public FoxIllusion() {
        super();
        this.name = "Fox Illusion";
        this.power = 65;
        this.variance = 5;
        this.speed = 0;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
