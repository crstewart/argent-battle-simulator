package com.argentstew.simulator.battle.vg.sylvanas;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sylvanas
 * 8/24/2019
 *
 * @author Craig
 */
public class LifeDrain extends MagicAttack {

    public LifeDrain() {
        super();
        this.name = "Life Drain";
        this.description = "Heals for half the damage dealt";
        this.power = 15;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);
        this.owner.heal(report.getDamage());
        return report;
    }
}
