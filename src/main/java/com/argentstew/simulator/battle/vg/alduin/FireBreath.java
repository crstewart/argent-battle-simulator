package com.argentstew.simulator.battle.vg.alduin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.alduin
 * 8/27/2019
 *
 * @author Craig
 */
public class FireBreath extends RangedAttack {

    public FireBreath() {
        super();
        this.name = "Fire Breath (Yol Toor Shul)";
        this.power = 90;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
