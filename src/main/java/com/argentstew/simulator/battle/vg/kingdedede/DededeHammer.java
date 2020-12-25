package com.argentstew.simulator.battle.vg.kingdedede;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kingdedede
 * 8/24/2019
 *
 * @author Craig
 */
public class DededeHammer extends MeleeAttack {

    public DededeHammer() {
        super();
        this.name = "Dedede Hammer";
        this.power = 100;
        this.variance = 10;
        this.speed = 3.5;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
