package com.argentstew.simulator.battle.vg.kosmos;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kosmos
 * 8/24/2019
 *
 * @author Craig
 */
public class FGShot extends RangedAttack {

    public FGShot() {
        super();
        this.name = "F-G-SHOT";
        this.power = 70;
        this.variance = 14;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }
}
