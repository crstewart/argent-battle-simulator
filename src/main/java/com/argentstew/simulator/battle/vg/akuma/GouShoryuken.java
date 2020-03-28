package com.argentstew.simulator.battle.vg.akuma;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.akuma
 * 8/24/2019
 *
 * @author Craig
 */
public class GouShoryuken extends MeleeAttack {

    public GouShoryuken() {
        super();
        this.name = "Gou Shoryuken";
        this.power = 65;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
