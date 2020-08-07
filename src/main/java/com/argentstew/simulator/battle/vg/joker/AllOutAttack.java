package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/24/2019
 *
 * @author Craig
 */
public class AllOutAttack extends MeleeXStrike {

    public AllOutAttack() {
        super();
        this.name = "All-Out Attack";
        this.power = 230;
        this.variance = 15;
        this.speed = 4;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.SLASH, AttackSubType.ASSIST);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
