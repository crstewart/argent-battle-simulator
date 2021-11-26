package com.argentstew.simulator.battle.vg.jin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;
import com.argentstew.simulator.battle.fighter.FighterClassification;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jin
 * 8/24/2019
 *
 * @author Craig
 */
public class ElectricWindGodFist extends MeleeAttack implements ShapeshiftAction {

    public ElectricWindGodFist() {
        super();
        this.name = "Electric Wind God Fist";
        this.description = "Changes the user into humanoid form until another form is taken";
        this.power = 65;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean hasClassToReplace() {
        return owner.getClassifications().contains(FighterClassification.DEMONIC);
    }

    @Override
    public void replaceClass() {
        owner.getClassifications().remove(FighterClassification.DEMONIC);
        owner.getClassifications().add(FighterClassification.HUMANOID);
    }
}
