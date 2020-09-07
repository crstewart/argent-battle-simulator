package com.argentstew.simulator.battle.vg.deathwing;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.deathwing
 * 8/24/2019
 *
 * @author Craig
 */
public class EarthShatter extends MagicAttack {

    public EarthShatter() {
        super();
        this.name = "Earth Shatter";
        this.power = 65;
        this.variance = 10;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }
}
