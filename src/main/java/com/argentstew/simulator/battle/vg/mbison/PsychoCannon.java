package com.argentstew.simulator.battle.vg.mbison;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mbison
 * 8/24/2019
 *
 * @author Craig
 */
public class PsychoCannon extends RangedAttack {

    public PsychoCannon() {
        super();
        this.name = "Psycho Cannon";
        this.power = 75;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.MYSTIC);
        this.characteristics = Collections.emptyList();
    }
}
