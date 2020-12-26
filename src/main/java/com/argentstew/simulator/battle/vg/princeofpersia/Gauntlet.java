package com.argentstew.simulator.battle.vg.princeofpersia;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.princeofpersia
 * 8/27/2019
 *
 * @author Craig
 */
public class Gauntlet extends MeleeAttack {

    public Gauntlet() {
        super();
        this.name = "Gauntlet";
        this.power = 55;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }
}
