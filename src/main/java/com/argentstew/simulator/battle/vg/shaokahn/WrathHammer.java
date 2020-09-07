package com.argentstew.simulator.battle.vg.shaokahn;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shaokahn
 * 8/27/2019
 *
 * @author Craig
 */
public class WrathHammer extends MeleeAttack {

    public WrathHammer() {
        super();
        this.name = "Wrath Hammer";
        this.power = 65;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
