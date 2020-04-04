package com.argentstew.simulator.battle.vg.steve;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.steve
 * 8/24/2019
 *
 * @author Craig
 */
public class DiamondSword extends MeleeXStrike {

    public DiamondSword() {
        super();
        this.name = "Diamond Sword";
        this.power = 240;
        this.variance = 15;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
