package com.argentstew.simulator.battle.vg.kirby;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kirby
 * 8/24/2019
 *
 * @author Craig
 */
public class CutterBoomerang extends RangedAttack {

    public CutterBoomerang() {
        super();
        this.name = "Cutter Boomerang";
        this.power = 80;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
