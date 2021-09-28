package com.argentstew.simulator.battle.vg.wander;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wander
 * 8/27/2019
 *
 * @author Craig
 */
public class StrikeWeakness extends MeleeAttack {

    public StrikeWeakness() {
        super();
        this.name = "Strike Weakness";
        this.description = "Cannot miss, always critical hits, and applies bleed status for 3 turns";
        this.power = 60;
        this.variance = 7;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss()) {
            defender.setStatus(new StatusEffect(StatusType.BLEED, 3));
        }

        return damageReport;
    }

    @Override
    public double getMissChance(Fighter defender) {
        return 0;
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 1;
    }

    @Override
    public boolean isAllowed() {
        return Wander.FOUND_WEAK_SPOT.equals(owner.getSelfStatus());
    }
}
