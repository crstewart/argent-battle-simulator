package com.argentstew.simulator.battle.vg.subzero;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.subzero
 * 8/27/2019
 *
 * @author Craig
 */
public class FrostHammer extends MeleeAttack {

    public FrostHammer() {
        super();
        this.name = "Frost Hammer";
        this.power = 80;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.ICE, AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
