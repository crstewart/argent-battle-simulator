package com.argentstew.simulator.battle.vg.tronbonne;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tronbonne
 * 8/24/2019
 *
 * @author Craig
 */
public class BonneStrike extends MeleeAttack {

    public BonneStrike() {
        super();
        this.name = "Bonne Strike";
        this.power = 65;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
