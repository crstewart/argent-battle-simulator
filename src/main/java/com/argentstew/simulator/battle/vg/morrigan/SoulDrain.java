package com.argentstew.simulator.battle.vg.morrigan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.morrigan
 * 8/27/2019
 *
 * @author Craig
 */
public class SoulDrain extends RangedAttack {

    public SoulDrain() {
        super();
        this.name = "Soul Drain";
        this.description = "Saps 1-2 points from the opponent's X-Strike meter";
        this.power = 35;
        this.variance = 2;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.CHI);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (defender.getXStrikeMeter() > 0) {
            double rng = Math.random();
            defender.adjustXStrikeMeter((rng < 0.2) ? -2 : -1);
            this.owner.adjustXStrikeMeter((rng < 0.2) ? 2 : 1);
        }

        return super.doAttack(defender);
    }
}
