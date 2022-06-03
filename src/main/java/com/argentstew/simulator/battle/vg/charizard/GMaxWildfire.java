package com.argentstew.simulator.battle.vg.charizard;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.charizard
 * 9/7/2019
 *
 * @author Craig
 */
public class GMaxWildfire extends RangedXStrike {

    public GMaxWildfire() {
        super();
        this.name = "G-Max Wildfire";
        this.description = "Applies burn status for three turns on hit";
        this.power = 240;
        this.variance = 10;
        this.speed = 7;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
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
