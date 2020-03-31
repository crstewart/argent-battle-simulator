package com.argentstew.simulator.battle.vg.magus;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.magus
 * 8/24/2019
 *
 * @author Craig
 */
public class Scythe extends MeleeAttack {

    public Scythe() {
        super();
        this.name = "Scythe";
        this.power = 45;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
