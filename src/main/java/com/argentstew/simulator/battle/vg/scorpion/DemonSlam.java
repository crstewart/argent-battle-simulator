package com.argentstew.simulator.battle.vg.scorpion;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.scorpion
 * 8/27/2019
 *
 * @author Craig
 */
public class DemonSlam extends MeleeAttack {

    public DemonSlam() {
        super();
        this.name = "Demon Slam";
        this.power = 50;
        this.variance = 4;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
