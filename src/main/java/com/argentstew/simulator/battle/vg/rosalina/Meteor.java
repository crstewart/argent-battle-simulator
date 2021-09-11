package com.argentstew.simulator.battle.vg.rosalina;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rosalina
 * 8/27/2019
 *
 * @author Craig
 */
public class Meteor extends MagicAttack {

    public Meteor() {
        super();
        this.name = "Meteor";
        this.power = 70;
        this.variance = 8;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }
}
