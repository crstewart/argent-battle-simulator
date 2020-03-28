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
public class BanditBoulder extends MeleeAttack {

    public BanditBoulder() {
        super();
        this.name = "Bandit Boulder";
        this.power = 70;
        this.variance = 7;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }
}
