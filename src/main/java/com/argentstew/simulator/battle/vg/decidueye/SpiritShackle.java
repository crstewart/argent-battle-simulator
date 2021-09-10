package com.argentstew.simulator.battle.vg.decidueye;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.decidueye
 * 9/7/2019
 *
 * @author Craig
 */
public class SpiritShackle extends RangedAttack {

    public SpiritShackle() {
        super();
        this.name = "Spirit Shackle";
        this.description = "Applies root status to the target for one turn";
        this.power = 80;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        defender.setStatus(new StatusEffect(StatusType.ROOTED, 2));
        return super.doAttack(defender);
    }
}
