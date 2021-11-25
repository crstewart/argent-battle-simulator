package com.argentstew.simulator.battle.vg.monsterhunter;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.monsterhunter
 * 8/24/2019
 *
 * @author Craig
 */
public class HuntersPride extends MeleeXStrike {

    public HuntersPride() {
        super();
        this.name = "Hunter's Pride";
        this.power = 280;
        this.variance = 18;
        this.speed = 4;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.PIERCE, AttackSubType.SMASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
