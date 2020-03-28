package com.argentstew.simulator.battle.vg.viewtifuljoe;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.viewtifuljoe
 * 8/24/2019
 *
 * @author Craig
 */
public class VfxSlow extends MeleeAttack {

    public VfxSlow() {
        super();
        this.name = "VFX Slow";
        this.power = 50;
        this.variance = 6;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
