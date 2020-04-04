package com.argentstew.simulator.battle.vg.handsomejack;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.handsomejack
 * 8/27/2019
 *
 * @author Craig
 */
public class Turret extends RangedAttack {

    public Turret() {
        super();
        this.name = "Turret";
        this.power = 60;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.RIFLE, AttackSubType.ASSIST);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }
}
