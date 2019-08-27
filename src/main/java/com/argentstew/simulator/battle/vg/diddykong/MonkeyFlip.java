package com.argentstew.simulator.battle.vg.diddykong;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diddykong
 * 8/26/2019
 *
 * @author Craig
 */
public class MonkeyFlip extends MeleeAttack {

    public MonkeyFlip() {
        super();
        this.name = "Monkey Flip";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
