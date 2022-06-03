package com.argentstew.simulator.battle.vg.pikachu;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 9/7/2019
 *
 * @author Craig
 */
public class BodySlam extends MeleeAttack {

    public BodySlam() {
        super();
        this.name = "Body Slam";
        this.description = "Has a 30% chance to apply the paralysis status on hit";
        this.power = 85;
        this.variance = 8;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            double paralysisChance = Math.random();
            if (paralysisChance < 0.3) {
                defender.setStatus(new StatusEffect(StatusType.PARALYSIS));
            }
        }

        return damageReport;
    }
}
