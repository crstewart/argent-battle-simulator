package com.argentstew.simulator.battle.vg.drwily;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class RobotMasterAssault extends MeleeXStrike {

    public RobotMasterAssault() {
        super();
        this.name = "Robot Master Assault";
        this.power = 235;
        this.variance = 12;
        this.speed = 4;
        this.subtypes = Arrays.asList(AttackSubType.FIRE, AttackSubType.ICE, AttackSubType.THUNDER, AttackSubType.TOXIC,
                AttackSubType.EARTH, AttackSubType.EXPLOSIVE, AttackSubType.NATURE, AttackSubType.METAL);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
