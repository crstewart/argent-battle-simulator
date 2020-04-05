package com.argentstew.simulator.battle.vg.diablo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diablo
 * 8/27/2019
 *
 * @author Craig
 */
public class FireStomp extends RangedAttack {

    public FireStomp() {
        super();
        this.name = "Fire Stomp";
        this.power = 50;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
