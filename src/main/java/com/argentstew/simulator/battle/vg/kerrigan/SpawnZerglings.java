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
public class SpawnZerglings extends RangedAttack {

    public SpawnZerglings() {
        super();
        this.name = "Spawn Zerglings";
        this.power = 30;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.ASSIST);
        this.characteristics = Collections.emptyList();
    }
}
