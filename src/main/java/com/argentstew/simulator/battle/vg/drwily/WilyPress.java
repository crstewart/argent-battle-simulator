package com.argentstew.simulator.battle.vg.drwily;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.drwily
 * 8/27/2019
 *
 * @author Craig
 */
public class WilyPress extends MeleeAttack {

    public WilyPress() {
        super();
        this.name = "Wily Press";
        this.power = 90;
        this.variance = 8;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
