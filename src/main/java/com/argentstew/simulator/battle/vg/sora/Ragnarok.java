package com.argentstew.simulator.battle.vg.sora;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sora
 * 8/24/2019
 *
 * @author Craig
 */
public class Ragnarok extends MagicXStrike {

    public Ragnarok() {
        super();
        this.name = "Ragnarok";
        this.power = 240;
        this.variance = 14;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNDODGEABLE, AttackCharacteristic.UNGUARDABLE);
    }
}
