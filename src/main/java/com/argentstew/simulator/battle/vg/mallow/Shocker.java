package com.argentstew.simulator.battle.vg.mallow;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mallow
 * 8/27/2019
 *
 * @author Craig
 */
public class Shocker extends MagicAttack {

    public Shocker() {
        super();
        this.name = "Shocker";
        this.power = 100;
        this.variance = 12;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
