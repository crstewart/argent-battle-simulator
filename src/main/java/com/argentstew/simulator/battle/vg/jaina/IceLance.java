package com.argentstew.simulator.battle.vg.jaina;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jaina
 * 8/27/2019
 *
 * @author Craig
 */
public class IceLance extends MagicAttack {

    public IceLance() {
        super();
        this.name = "Ice Lance";
        this.description = "If the user is 'Frostbitten' this always critical hits, else applies 'Frostbitten'";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.ICE, AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);

        if (defender.getStatus() != null && defender.getStatus().getType() == StatusType.FROSTBITE) {
            defender.setStatus(null);
        } else {
            defender.setStatus(new StatusEffect(StatusType.FROSTBITE));
        }

        return report;
    }

    @Override
    public double getCritChance(Fighter defender) {
        return (defender.getStatus() != null && defender.getStatus().getType() == StatusType.FROSTBITE)
                ? 1 : super.getCritChance(defender);
    }
}
