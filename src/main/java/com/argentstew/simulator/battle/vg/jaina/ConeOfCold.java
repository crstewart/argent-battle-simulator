package com.argentstew.simulator.battle.vg.jaina;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jaina
 * 8/27/2019
 *
 * @author Craig
 */
public class ConeOfCold extends MagicAttack {

    public ConeOfCold() {
        super();
        this.name = "Cone of Cold";
        this.description = "If the user is 'Frostbitten' this always critical hits, else applies 'Frostbitten'";
        this.power = 45;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Arrays.asList(AttackSubType.ICE, AttackSubType.AIR);
        this.characteristics = Collections.emptyList();
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
