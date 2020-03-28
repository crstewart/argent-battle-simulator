package com.argentstew.simulator.battle.vg.zero;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.zero
 * 8/27/2019
 *
 * @author Craig
 */
public class Ryuenjin extends MeleeAttack {

    public Ryuenjin() {
        super();
        this.name = "Ryuenjin";
        this.power = 60;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
