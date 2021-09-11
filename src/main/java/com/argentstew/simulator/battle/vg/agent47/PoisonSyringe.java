package com.argentstew.simulator.battle.vg.agent47;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.agent47
 * 8/24/2019
 *
 * @author Craig
 */
public class PoisonSyringe extends MeleeAttack {

    private int uses;

    public PoisonSyringe() {
        super();
        this.name = "Poison Syringe";
        this.description = "Only usable once; applies poison status for three turns on hit";
        this.power = 20;
        this.variance = 3;
        this.speed = 4;
        this.uses = 1;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        uses -= 1;
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            defender.setStatus(new StatusEffect(StatusType.POISON, 3));
        }

        return damageReport;
    }

    @Override
    public boolean isAllowed() {
        return uses > 0;
    }
}
