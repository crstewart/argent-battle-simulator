package com.argentstew.simulator.battle.vg.dante;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dante
 * 8/27/2019
 *
 * @author Craig
 */
public class JamSession extends MeleeAttack {

    public JamSession() {
        super();
        this.name = "Jam Session";
        this.power = 60;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.THUNDER, AttackSubType.SOUND);
        this.characteristics = Collections.emptyList();
    }
}
