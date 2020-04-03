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
public class GigawattBlades extends MeleeAttack {

    public GigawattBlades() {
        super();
        this.name = "Gigawatt Blades";
        this.power = 65;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
