package com.argentstew.simulator.battle.vg.ryu;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryu
 * 8/24/2019
 *
 * @author Craig
 */
public class JoudanSokutigeri extends MeleeAttack {

    public JoudanSokutigeri() {
        super();
        this.name = "Joudan Sokutigeri";
        this.power = 75;
        this.variance = 8;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
