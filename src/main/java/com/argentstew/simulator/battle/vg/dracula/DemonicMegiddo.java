package com.argentstew.simulator.battle.vg.dracula;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dracula
 * 8/24/2019
 *
 * @author Craig
 */
public class DemonicMegiddo extends MagicXStrike {

    public DemonicMegiddo() {
        super();
        this.name = "Demonic Megiddo";
        this.power = 300;
        this.variance = 15;
        this.speed = 5;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNDODGEABLE, AttackCharacteristic.UNGUARDABLE);
    }
}
