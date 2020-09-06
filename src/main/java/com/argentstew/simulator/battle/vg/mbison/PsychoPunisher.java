package com.argentstew.simulator.battle.vg.mbison;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mbison
 * 8/24/2019
 *
 * @author Craig
 */
public class PsychoPunisher extends MeleeXStrike {

    public PsychoPunisher() {
        super();
        this.name = "Psycho Punisher";
        this.power = 275;
        this.variance = 15;
        this.speed = 5;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.MYSTIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
