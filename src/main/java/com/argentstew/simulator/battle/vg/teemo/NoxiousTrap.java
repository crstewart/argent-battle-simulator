package com.argentstew.simulator.battle.vg.teemo;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.teemo
 * 8/24/2019
 *
 * @author Craig
 */
public class NoxiousTrap extends MagicXStrike {

    public NoxiousTrap() {
        super();
        this.name = "Noxious Trap";
        this.power = 230;
        this.variance = 20;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.EXPLOSIVE, AttackSubType.TOXIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
