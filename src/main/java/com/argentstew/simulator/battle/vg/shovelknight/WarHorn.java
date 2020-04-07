package com.argentstew.simulator.battle.vg.shovelknight;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shovelknight
 * 8/24/2019
 *
 * @author Craig
 */
public class WarHorn extends MagicXStrike {

    public WarHorn() {
        super();
        this.name = "Super Nova";
        this.power = 250;
        this.variance = 16;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SOUND);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
