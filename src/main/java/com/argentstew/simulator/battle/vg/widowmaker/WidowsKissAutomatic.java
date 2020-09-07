package com.argentstew.simulator.battle.vg.widowmaker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.widowmaker
 * 8/27/2019
 *
 * @author Craig
 */
public class WidowsKissAutomatic extends RangedAttack {

    public WidowsKissAutomatic() {
        super();
        this.name = "Widow's Kiss (Automatic)";
        this.power = 50;
        this.variance = 20;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }
}
