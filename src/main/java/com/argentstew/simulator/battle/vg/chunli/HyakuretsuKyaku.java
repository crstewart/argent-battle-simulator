package com.argentstew.simulator.battle.vg.chunli;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.chunli
 * 8/24/2019
 *
 * @author Craig
 */
public class HyakuretsuKyaku extends MeleeAttack {

    public HyakuretsuKyaku() {
        super();
        this.name = "Hyakuretsu Kyaku";
        this.power = 50;
        this.variance = 9;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
