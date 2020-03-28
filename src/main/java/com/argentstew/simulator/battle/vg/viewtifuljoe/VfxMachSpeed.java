package com.argentstew.simulator.battle.vg.viewtifuljoe;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.viewtifuljoe
 * 8/26/2019
 *
 * @author Craig
 */
public class VfxMachSpeed extends MeleeXStrike {

    public VfxMachSpeed() {
        super();
        this.name = "VFX Mach Speed";
        this.power = 240;
        this.variance = 12;
        this.speed = 0.5;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
