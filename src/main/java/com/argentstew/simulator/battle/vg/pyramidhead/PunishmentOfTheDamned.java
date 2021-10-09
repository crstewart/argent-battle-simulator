package com.argentstew.simulator.battle.vg.pyramidhead;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pyramidhead
 * 8/24/2019
 *
 * @author Craig
 */
public class PunishmentOfTheDamned extends MeleeXStrike {

    public PunishmentOfTheDamned() {
        super();
        this.name = "Punishment of the Damned";
        this.power = 300;
        this.variance = 10;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
