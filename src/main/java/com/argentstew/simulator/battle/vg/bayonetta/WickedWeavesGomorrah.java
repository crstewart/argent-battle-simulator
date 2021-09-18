package com.argentstew.simulator.battle.vg.bayonetta;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bayonetta
 * 8/27/2019
 *
 * @author Craig
 */
public class WickedWeavesGomorrah extends RangedXStrike implements ShapeshiftAction {

    public WickedWeavesGomorrah() {
        super();
        this.name = "Wicked Weaves (Gomorrah)";
        this.description = "Deals triple damage to divine opponents";
        this.power = 250;
        this.variance = 15;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.BITE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (defender.getClassifications().contains(FighterClassification.DIVINE)) {
            damageReport.setDamage(damageReport.getDamage() * 3);
        }

        return damageReport;
    }

    @Override
    public boolean hasClassToReplace() {
        return owner.getClassifications().contains(FighterClassification.ANIMAL);
    }

    @Override
    public void replaceClass() {
        owner.getClassifications().remove(FighterClassification.ANIMAL);
        owner.getClassifications().add(FighterClassification.HUMANOID);
    }
}
