package com.argentstew.simulator.battle.vg.jaina;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jaina
 * 8/24/2019
 *
 * @author Craig
 */
public class RingOfFrost extends MagicXStrike {

    public RingOfFrost() {
        super();
        this.name = "Ring of Frost";
        this.power = 180;
        this.variance = 12;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);

        if (Jaina.STATUS_FROSTBITTEN.equals(defender.getStatus())) {
            defender.setStatus(null);
        } else {
            defender.setStatus(Jaina.STATUS_FROSTBITTEN);
        }

        return report;
    }

    @Override
    public double getCritChance(Fighter defender) {
        return Jaina.STATUS_FROSTBITTEN.equals(defender.getStatus()) ? 1 : super.getCritChance(defender);
    }
}
