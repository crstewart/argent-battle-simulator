package com.argentstew.simulator.battle.vg.arthas;

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
 * com.argentstew.simulator.battle.vg.arthas
 * 8/24/2019
 *
 * @author Craig
 */
public class ArmyOfTheDead extends RangedXStrike {

    public ArmyOfTheDead() {
        super();
        this.name = "Army of the Dead";
        this.power = 200;
        this.variance = 20;
        this.speed = 4;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.TOXIC, AttackSubType.ASSIST);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
