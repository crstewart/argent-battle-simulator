package com.argentstew.simulator.battle.vg.sigma;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;
import com.argentstew.simulator.battle.trait.impl.ExMaverickHunter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sigma
 * 8/27/2019
 *
 * @author Craig
 */
public class ReaperScythe extends MeleeAttack {

    public ReaperScythe() {
        super();
        this.name = "Reaper Scythe";
        this.power = 60;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);
        if (!report.isMiss()) {
            ExMaverickHunter trait = owner.getTraits().getTrait(ExMaverickHunter.class);
            if (trait != null && !trait.isActivated()) {
                if (defender.getClassifications().contains(FighterClassification.HUMANOID)) {
                    report.setDamage(report.getDamage() * 2);
                }
                defender.setStatus(new StatusEffect(StatusType.VIRUS, 5));
                trait.setActivated(true);
            }
        }

        return report;
    }
}
