package com.argentstew.simulator.battle.vg.diddykong;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diddykong
 * 8/26/2019
 *
 * @author Craig
 */
public class PeanutPopgun extends RangedAttack {

    public PeanutPopgun() {
        super();
        this.name = "Peanut Popgun";
        this.power = 60;
        this.variance = 8;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Collections.emptyList();
    }
}
