package com.argentstew.simulator.battle.vg.magus;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.crono
 * 8/24/2019
 *
 * @author Craig
 */
public class DarkMatter extends MagicXStrike {

    public DarkMatter() {
        super();
        this.name = "Dark Matter";
        this.power = 250;
        this.variance = 16;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNDODGEABLE, AttackCharacteristic.UNGUARDABLE);
    }
}
