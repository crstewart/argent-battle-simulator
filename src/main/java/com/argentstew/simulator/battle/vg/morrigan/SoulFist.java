package com.argentstew.simulator.battle.vg.morrigan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.morrigan
 * 8/27/2019
 *
 * @author Craig
 */
public class SoulFist extends RangedAttack {

    public SoulFist() {
        super();
        this.name = "Soul Fist";
        this.power = 65;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.CHI);
        this.characteristics = Collections.emptyList();
    }
}
