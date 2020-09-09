package com.argentstew.simulator.battle.vg.ragna;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ragna
 * 8/24/2019
 *
 * @author Craig
 */
public class BloodScythe extends MeleeAttack {

    public BloodScythe() {
        super();
        this.name = "Blood Scythe";
        this.power = 60;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
