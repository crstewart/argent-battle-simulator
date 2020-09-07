package com.argentstew.simulator.battle.vg.samfisher;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samfisher
 * 8/24/2019
 *
 * @author Craig
 */
public class KravMaga extends MeleeAttack {

    public KravMaga() {
        super();
        this.name = "Krav Maga";
        this.power = 40;
        this.variance = 6;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
