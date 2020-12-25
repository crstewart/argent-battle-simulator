package com.argentstew.simulator.battle.vg.ganondorf;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ganondorf
 * 9/7/2019
 *
 * @author Craig
 */
public class WarlockPunch extends MeleeAttack {

    public WarlockPunch() {
        super();
        this.name = "Warlock Punch";
        this.power = 150;
        this.variance = 15;
        this.speed = 7;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }
}
