package com.argentstew.simulator.battle.vg.scorpion;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.scorpion
 * 8/27/2019
 *
 * @author Craig
 */
public class DemonBreath extends RangedAttack {

    public DemonBreath() {
        super();
        this.name = "Spear";
        this.power = 55;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
