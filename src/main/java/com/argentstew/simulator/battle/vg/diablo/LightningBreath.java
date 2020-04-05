package com.argentstew.simulator.battle.vg.diablo;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.vg.jaina.Jaina;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diablo
 * 8/24/2019
 *
 * @author Craig
 */
public class LightningBreath extends RangedXStrike {

    public LightningBreath() {
        super();
        this.name = "Lightning Breath";
        this.power = 230;
        this.variance = 13;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
