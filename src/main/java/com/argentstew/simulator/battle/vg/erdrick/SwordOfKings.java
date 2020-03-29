package com.argentstew.simulator.battle.vg.erdrick;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.erdrick
 * 8/27/2019
 *
 * @author Craig
 */
public class SwordOfKings extends MeleeAttack {

    public SwordOfKings() {
        super();
        this.name = "Sword of Kings";
        this.power = 55;
        this.variance = 6;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
