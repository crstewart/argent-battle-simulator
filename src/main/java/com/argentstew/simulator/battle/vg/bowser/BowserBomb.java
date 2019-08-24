package com.argentstew.simulator.battle.vg.bowser;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class BowserBomb extends MeleeAttack {

    public BowserBomb() {
        super();
        this.name = "Bowser Bomb";
        this.power = 70;
        this.variance = 4;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
