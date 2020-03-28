package com.argentstew.simulator.battle.vg.dante;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dante
 * 8/27/2019
 *
 * @author Craig
 */
public class Crystal extends MagicAttack {

    public Crystal() {
        super();
        this.name = "Crystal";
        this.power = 60;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Collections.emptyList();
        this.setRequiresMeleeRange(true);
    }
}
