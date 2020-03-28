package com.argentstew.simulator.battle.vg.dante;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dante
 * 8/27/2019
 *
 * @author Craig
 */
public class Volcano extends MagicAttack {

    public Volcano() {
        super();
        this.name = "Volcano";
        this.power = 70;
        this.variance = 4;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
        this.setRequiresMeleeRange(true);
    }
}
