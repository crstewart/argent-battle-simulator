package com.argentstew.simulator.battle.vg.amaterasu;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.amaterasu
 * 8/24/2019
 *
 * @author Craig
 */
public class ColdStar extends MagicAttack {

    public ColdStar() {
        super();
        this.name = "Cold Star";
        this.power = 60;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Collections.emptyList();
    }
}
