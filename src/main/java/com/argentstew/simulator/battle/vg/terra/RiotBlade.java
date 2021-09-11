package com.argentstew.simulator.battle.vg.terra;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terra
 * 8/27/2019
 *
 * @author Craig
 */
public class RiotBlade extends MagicAttack {

    public RiotBlade() {
        super();
        this.name = "Riot Blade";
        this.power = 75;
        this.variance = 8;
        this.speed = 1;
        this.requiresMeleeRange = true;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
