package com.argentstew.simulator.battle.vg.sephiroth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sephiroth
 * 8/27/2019
 *
 * @author Craig
 */
public class Meteor extends MagicAttack {

    public Meteor() {
        super();
        this.name = "Meteor";
        this.power = 60;
        this.variance = 4;
        this.speed = 5;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getCritChance(Fighter defender) {
        return 1;
    }
}
