package com.argentstew.simulator.battle.vg.bomberman;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.bomberman
 * 8/24/2019
 *
 * @author Craig
 */
public class PowerBomb extends RangedXStrike {

    public PowerBomb() {
        super();
        this.name = "Power Bomb";
        this.power = 200;
        this.variance = 20;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.FIRE, AttackSubType.EXPLOSIVE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
