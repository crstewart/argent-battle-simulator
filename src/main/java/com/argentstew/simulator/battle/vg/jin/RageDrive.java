package com.argentstew.simulator.battle.vg.jin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jin
 * 8/24/2019
 *
 * @author Craig
 */
public class RageDrive extends MeleeAttack implements ShapeshiftAction {

    public RageDrive() {
        super();
        this.name = "Rage Drive";
        this.description = "Changes the user between humanoid and demonic forms";
        this.power = 80;
        this.variance = 8;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean hasClassToReplace() {
        return true;
    }

    @Override
    public void replaceClass() {
        if (owner.getClassifications().contains(FighterClassification.DEMONIC)) {
            owner.getClassifications().remove(FighterClassification.DEMONIC);
            owner.getClassifications().add(FighterClassification.HUMANOID);
        } else {
            owner.getClassifications().remove(FighterClassification.HUMANOID);
            owner.getClassifications().add(FighterClassification.DEMONIC);
        }
    }
}
