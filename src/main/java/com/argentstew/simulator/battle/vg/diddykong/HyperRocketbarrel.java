package com.argentstew.simulator.battle.vg.diddykong;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diddykong
 * 8/26/2019
 *
 * @author Craig
 */
public class HyperRocketbarrel extends MeleeXStrike {

    public HyperRocketbarrel() {
        super();
        this.name = "Hyper Rocketbarrel";
        this.power = 230;
        this.variance = 15;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.EXPLOSIVE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
