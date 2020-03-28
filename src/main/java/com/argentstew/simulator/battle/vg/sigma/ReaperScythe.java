package com.argentstew.simulator.battle.vg.sigma;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sigma
 * 8/27/2019
 *
 * @author Craig
 */
public class ReaperScythe extends MeleeAttack {

    public ReaperScythe() {
        super();
        this.name = "Reaper Scythe";
        this.power = 65;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
