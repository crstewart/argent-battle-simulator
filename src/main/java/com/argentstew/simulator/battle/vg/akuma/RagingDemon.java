package com.argentstew.simulator.battle.vg.akuma;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryu
 * 8/24/2019
 *
 * @author Craig
 */
public class RagingDemon extends MeleeXStrike {

    public RagingDemon() {
        super();
        this.name = "Raging Demon";
        this.power = 350;
        this.variance = 30;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
