package com.argentstew.simulator.battle.vg.charizard;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.charizard
 * 9/8/2019
 *
 * @author Craig
 */
public class Flamethrower extends RangedAttack {

    public Flamethrower() {
        super();
        this.name = "Flamethrower";
        this.description = "Has a 10% chance to apply burn status for five turns on hit";
        this.power = 90;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            double burnChance = Math.random();
            if (burnChance < 0.1) {
                defender.setStatus(new StatusEffect(StatusType.BURN, 5));
            }
        }

        return damageReport;
    }
}
