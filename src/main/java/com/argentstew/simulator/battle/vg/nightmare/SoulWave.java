package com.argentstew.simulator.battle.vg.nightmare;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.nightmare
 * 8/27/2019
 *
 * @author Craig
 */
public class SoulWave extends MagicAttack {

    public SoulWave() {
        super();
        this.name = "Soul Wave";
        this.power = 50;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
        this.requiresMeleeRange = true;
    }
}
