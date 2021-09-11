package com.argentstew.simulator.battle.vg.peach;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.peach
 * 8/24/2019
 *
 * @author Craig
 */
public class SleepyTime extends MagicAttack {

    public static final int MP_COST = 4;

    public SleepyTime() {
        super();
        this.name = "Sleepy Time";
        this.description = "Uses 4 SP; applies sleep status for 3 turns on hit";
        this.power = 15;
        this.variance = 3;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.MYSTIC);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.useMagic(MP_COST);
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            defender.setStatus(new StatusEffect(StatusType.SLEEP, 3));
        }

        return damageReport;
    }

    @Override
    public boolean isAllowed() {
        return owner.getMp() >= MP_COST;
    }
}
