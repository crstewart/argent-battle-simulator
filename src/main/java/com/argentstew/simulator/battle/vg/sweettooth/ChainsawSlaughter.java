package com.argentstew.simulator.battle.vg.sweettooth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sweettooth
 * 8/24/2019
 *
 * @author Craig
 */
public class ChainsawSlaughter extends MeleeAttack {

    public ChainsawSlaughter() {
        super();
        this.name = "Chainsaw Slaughter";
        this.power = 80;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
