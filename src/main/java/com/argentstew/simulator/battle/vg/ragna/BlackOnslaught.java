package com.argentstew.simulator.battle.vg.ragna;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ragna
 * 8/24/2019
 *
 * @author Craig
 */
public class BlackOnslaught extends MeleeXStrike {

    public BlackOnslaught() {
        super();
        this.name = "Black Onslaught";
        this.description = "Heals for half the damage dealt";
        this.power = 180;
        this.variance = 15;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.SLASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);
        this.owner.heal(report.getDamage() / 2);
        return report;
    }
}
