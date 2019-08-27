package com.argentstew.simulator.battle.vg.link;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.link
 * 8/27/2019
 *
 * @author Craig
 */
public class MasterSword extends MeleeAttack {

    public MasterSword() {
        super();
        this.name = "Master Sword";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
    }
}
