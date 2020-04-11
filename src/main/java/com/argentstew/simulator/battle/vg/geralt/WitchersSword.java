package com.argentstew.simulator.battle.vg.geralt;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.geralt
 * 9/7/2019
 *
 * @author Craig
 */
public class WitchersSword extends MeleeAttack {

    public WitchersSword() {
        super();
        this.name = "Witcher's Sword";
        this.power = 55;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
