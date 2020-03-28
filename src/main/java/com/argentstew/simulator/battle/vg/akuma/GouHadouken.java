package com.argentstew.simulator.battle.vg.akuma;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.akuma
 * 8/24/2019
 *
 * @author Craig
 */
public class GouHadouken extends RangedAttack {

    public GouHadouken() {
        super();
        this.name = "Gou Hadouken";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.CHI, AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }
}
