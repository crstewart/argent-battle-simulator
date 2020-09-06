package com.argentstew.simulator.battle.vg.sweettooth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sweettooth
 * 8/24/2019
 *
 * @author Craig
 */
public class MacheteMassacre extends MeleeAttack {

    public MacheteMassacre() {
        super();
        this.name = "Machete Massacre";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
