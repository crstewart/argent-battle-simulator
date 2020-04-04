package com.argentstew.simulator.battle.vg.marcusfenix;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.marcusfenix
 * 8/24/2019
 *
 * @author Craig
 */
public class LancerChainsaw extends MeleeAttack {

    public LancerChainsaw() {
        super();
        this.name = "Lancer Chainsaw";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
