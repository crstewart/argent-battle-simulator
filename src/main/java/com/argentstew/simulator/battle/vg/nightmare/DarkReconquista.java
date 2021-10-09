package com.argentstew.simulator.battle.vg.nightmare;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.nightmare
 * 8/24/2019
 *
 * @author Craig
 */
public class DarkReconquista extends MeleeXStrike {

    public DarkReconquista() {
        super();
        this.name = "Dark Reconquista";
        this.power = 280;
        this.variance = 14;
        this.speed = 6;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.DARK, AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
