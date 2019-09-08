package com.argentstew.simulator.battle.vg.ganondorf;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ganondorf
 * 9/7/2019
 *
 * @author Craig
 */
public class MagicOrb extends MagicAttack {

    public MagicOrb() {
        super();
        this.name = "Magic Orb";
        this.power = 50;
        this.variance = 5;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }
}
