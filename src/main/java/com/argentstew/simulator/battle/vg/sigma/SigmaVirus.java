package com.argentstew.simulator.battle.vg.sigma;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sigma
 * 8/24/2019
 *
 * @author Craig
 */
public class SigmaVirus extends RangedXStrike {

    public SigmaVirus() {
        super();
        this.name = "Sigma Virus";
        this.description = "Applies virus status on hit until the end of the match";
        this.power = 250;
        this.variance = 20;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.THUNDER, AttackSubType.TOXIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);

        defender.setStatus(new StatusEffect(StatusType.VIRUS));

        return report;
    }
}
