package com.argentstew.simulator.battle.vg.tracer;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tracer
 * 8/24/2019
 *
 * @author Craig
 */
public class MeleeAttack extends com.argentstew.simulator.battle.action.attack.MeleeAttack {

    public MeleeAttack() {
        super();
        this.name = "Melee Attack";
        this.power = 50;
        this.variance = 6;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 25));
        return super.doAttack(defender);
    }
}
