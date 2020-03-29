package com.argentstew.simulator.battle.vg.squall;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.squall
 * 8/27/2019
 *
 * @author Craig
 */
public class BlizzardBarret extends MagicAttack {

    public BlizzardBarret() {
        super();
        this.name = "Blizzard Barret";
        this.power = 65;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Collections.emptyList();
    }
}
