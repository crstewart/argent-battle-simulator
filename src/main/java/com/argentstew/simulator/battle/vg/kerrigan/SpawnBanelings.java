package com.argentstew.simulator.battle.vg.kerrigan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kerrigan
 * 8/24/2019
 *
 * @author Craig
 */
public class SpawnBanelings extends RangedAttack {

    public SpawnBanelings() {
        super();
        this.name = "Spawn Zerglings";
        this.power = 50;
        this.variance = 10;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.ASSIST);
        this.characteristics = Collections.emptyList();
    }
}
