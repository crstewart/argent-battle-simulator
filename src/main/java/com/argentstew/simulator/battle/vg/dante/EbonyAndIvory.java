package com.argentstew.simulator.battle.vg.dante;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.morrigan
 * 8/27/2019
 *
 * @author Craig
 */
public class EbonyAndIvory extends RangedAttack {

    public EbonyAndIvory() {
        super();
        this.name = "Ebony and Ivory";
        this.power = 75;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }
}
