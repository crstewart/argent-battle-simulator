package com.argentstew.simulator.battle.vg.ganondorf;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ganondorf
 * 9/7/2019
 *
 * @author Craig
 */
public class SwordOfDespair extends MeleeAttack {

    public SwordOfDespair() {
        super();
        this.name = "Sword of Despair";
        this.power = 55;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }
}
