package com.argentstew.simulator.battle.vg.cole;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cole
 * 8/27/2019
 *
 * @author Craig
 */
public class ThunderDrop extends MeleeAttack {

    public ThunderDrop() {
        super();
        this.name = "Thunder Drop";
        this.power = 75;
        this.variance = 7;
        this.speed = 2.5;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
