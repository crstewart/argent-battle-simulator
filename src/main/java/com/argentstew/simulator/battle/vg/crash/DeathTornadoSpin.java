package com.argentstew.simulator.battle.vg.crash;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.crono
 * 8/24/2019
 *
 * @author Craig
 */
public class DeathTornadoSpin extends MeleeXStrike {

    public DeathTornadoSpin() {
        super();
        this.name = "Death Tornado Spin";
        this.power = 220;
        this.variance = 24;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.KICK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNDODGEABLE, AttackCharacteristic.UNGUARDABLE);
    }
}
