package com.argentstew.simulator.battle.vg.sigma;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
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
public class DoomBuster extends RangedAttack {

    public DoomBuster() {
        super();
        this.name = "Doom Buster";
        this.power = 70;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
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
