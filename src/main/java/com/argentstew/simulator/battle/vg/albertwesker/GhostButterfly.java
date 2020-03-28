package com.argentstew.simulator.battle.vg.albertwesker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.albertwesker
 * 8/24/2019
 *
 * @author Craig
 */
public class GhostButterfly extends MeleeAttack {

    public GhostButterfly() {
        super();
        this.name = "Ghost Butterfly";
        this.power = 55;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
