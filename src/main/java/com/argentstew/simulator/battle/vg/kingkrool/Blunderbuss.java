package com.argentstew.simulator.battle.vg.kingkrool;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kingkrool
 * 8/24/2019
 *
 * @author Craig
 */
public class Blunderbuss extends RangedAttack {

    public Blunderbuss() {
        super();
        this.name = "Blunderbuss";
        this.power = 65;
        this.variance = 6;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.SHOTGUN, AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
