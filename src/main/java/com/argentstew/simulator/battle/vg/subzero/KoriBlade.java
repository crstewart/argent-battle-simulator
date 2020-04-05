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
public class KoriBlade extends MeleeAttack {

    public KoriBlade() {
        super();
        this.name = "Kori Blade";
        this.power = 40;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
