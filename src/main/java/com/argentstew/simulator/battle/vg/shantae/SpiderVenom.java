package com.argentstew.simulator.battle.vg.shantae;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shantae
 * 8/24/2019
 *
 * @author Craig
 */
public class SpiderVenom extends RangedAttack implements ShapeshiftAction {

    public SpiderVenom() {
        super();
        this.name = "Spider Venom";
        this.description = "Changes the user from humanoid to animal until another non-animal action is chosen; applies poison status for 4 turns on hit";
        this.power = 10;
        this.variance = 2;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);

        if (!damageReport.isMiss()) {
            defender.setStatus(new StatusEffect(StatusType.POISON, 4));
        }

        return damageReport;
    }

    @Override
    public boolean hasClassToReplace() {
        return owner.getClassifications().contains(FighterClassification.HUMANOID);
    }

    @Override
    public void replaceClass() {
        owner.getClassifications().remove(FighterClassification.HUMANOID);
        owner.getClassifications().add(FighterClassification.ANIMAL);
    }
}
