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
public class Spear extends RangedAttack {

    public Spear() {
        super();
        this.name = "Spear";
        this.description = "Forces the opponent into melee range";
        this.power = 40;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);
        if (report.getDamage() > 0) {
            owner.getArena().fullAdvance(defender);
        }

        return report;
    }
}
