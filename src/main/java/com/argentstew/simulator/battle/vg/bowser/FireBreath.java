package com.argentstew.simulator.battle.vg.bowser;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bowser
 * 8/24/2019
 *
 * @author Craig
 */
public class FireBreath extends RangedAttack {

    public FireBreath() {
        super();
        this.name = "Fire Breath";
        this.description = "Applies burn status for three turns on hit";
        this.power = 20;
        this.variance = 2;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            defender.setStatus(new StatusEffect(StatusType.BURN, 3));
        }

        return damageReport;
    }
}
