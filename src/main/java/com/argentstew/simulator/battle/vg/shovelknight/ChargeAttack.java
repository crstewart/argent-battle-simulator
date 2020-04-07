package com.argentstew.simulator.battle.vg.shovelknight;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shovelknight
 * 8/27/2019
 *
 * @author Craig
 */
public class ChargeAttack extends MeleeAttack {

    public ChargeAttack() {
        super();
        this.name = "Charge Attack";
        this.power = 60;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
