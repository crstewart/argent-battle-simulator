package com.argentstew.simulator.battle.vg.mbison;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mbison
 * 8/24/2019
 *
 * @author Craig
 */
public class PsychoCrusher extends MeleeAttack {

    public PsychoCrusher() {
        super();
        this.name = "Psycho Crusher";
        this.power = 90;
        this.variance = 9;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.DARK, AttackSubType.MYSTIC);
        this.characteristics = Collections.emptyList();
    }
}
