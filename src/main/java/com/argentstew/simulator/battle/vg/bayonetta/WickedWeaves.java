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
public class WickedWeaves extends RangedXStrike implements ShapeshiftAction {

    private static final String BASE_NAME = "Wicked Weaves";

    public WickedWeaves() {
        super();
        this.name = BASE_NAME;
        this.description = "Power is increased by 50% and type is changed against demonic and divine opponents";
        this.power = 300;
        this.variance = 18;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (defender.getClassifications().contains(FighterClassification.DEMONIC)) {
            this.name += " (Madama Butterfly)";
            this.power = (int) Math.round(this.power * 1.5);
            this.subtypes = Collections.singletonList(AttackSubType.KICK);
        } else if (defender.getClassifications().contains(FighterClassification.DIVINE)) {
            this.name += " (Gomorrah)";
            this.power = (int) Math.round(this.power * 1.5);
            this.subtypes = Collections.singletonList(AttackSubType.BITE);
        } else {
            this.name += " (Hekatoncheir)";
        }

        return super.doAttack(defender);
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

    @Override
    public String getBaseName() {
        return BASE_NAME;
    }
}
