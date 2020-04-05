package com.argentstew.simulator.battle.vg.commandershepard;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.albertwesker
 * 8/24/2019
 *
 * @author Craig
 */
public class M920Cain extends RangedXStrike {

    public M920Cain() {
        super();
        this.name = "M-920 Cain";
        this.power = 280;
        this.variance = 12;
        this.speed = 5;
        this.subtypes = Arrays.asList(AttackSubType.EXPLOSIVE, AttackSubType.TOXIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
