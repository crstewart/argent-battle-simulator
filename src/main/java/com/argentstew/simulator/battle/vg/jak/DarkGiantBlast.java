package com.argentstew.simulator.battle.vg.jak;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jak
 * 8/24/2019
 *
 * @author Craig
 */
public class DarkGiantBlast extends RangedXStrike {

    public DarkGiantBlast() {
        super();
        this.name = "Dark Giant Blast";
        this.power = 230;
        this.variance = 14;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
