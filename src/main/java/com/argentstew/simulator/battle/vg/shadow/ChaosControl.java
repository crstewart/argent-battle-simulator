package com.argentstew.simulator.battle.vg.shadow;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shadow
 * 8/27/2019
 *
 * @author Craig
 */
public class ChaosControl extends RangedAttack {

    public ChaosControl() {
        super();
        this.name = "Chaos Control";
        this.description = "Applies the slow status for three turns on hit";
        this.power = 40;
        this.variance = 4;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.GRAVITY);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            defender.setStatus(new StatusEffect(StatusType.SLOW, 3));
        }

        return damageReport;
    }
}
