package com.argentstew.simulator.battle.vg.monsterhunter;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.monsterhunter
 * 8/24/2019
 *
 * @author Craig
 */
public class TranqBomb extends RangedAttack {

    public TranqBomb() {
        super();
        this.name = "Tranq Bomb";
        this.description = "Applies sleep status for 3 turns on hit";
        this.power = 10;
        this.variance = 1;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            defender.setStatus(new StatusEffect(StatusType.SLEEP, 3));
        }

        return damageReport;
    }
}
