package com.argentstew.simulator.battle.vg.shantae;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shantae
 * 8/24/2019
 *
 * @author Craig
 */
public class ElephantStomp extends MeleeAttack implements ShapeshiftAction {

    public ElephantStomp() {
        super();
        this.name = "Elephant Stomp";
        this.description = "Changes the user from humanoid to animal until another non-animal action is chosen";
        this.power = 90;
        this.variance = 12;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
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
