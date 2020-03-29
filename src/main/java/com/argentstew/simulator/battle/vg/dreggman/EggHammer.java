package com.argentstew.simulator.battle.vg.dreggman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dreggman
 * 8/27/2019
 *
 * @author Craig
 */
public class EggHammer extends MeleeAttack {

    public EggHammer() {
        super();
        this.name = "Egg Hammer";
        this.power = 80;
        this.variance = 6;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
