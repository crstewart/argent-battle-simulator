package com.argentstew.simulator.battle.vg.heihachi;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.heihachi
 * 8/24/2019
 *
 * @author Craig
 */
public class LightningHammer extends MeleeXStrike {

    public LightningHammer() {
        super();
        this.name = "Lightning Hammer";
        this.power = 230;
        this.variance = 12;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
