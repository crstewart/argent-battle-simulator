package com.argentstew.simulator.battle.vg.zelda;

import com.argentstew.simulator.battle.action.attack.RangedAttack;

/**
 * com.argentstew.simulator.battle.vg.zelda
 * 8/27/2019
 *
 * @author Craig
 */
public class ReflectedRangedAttack extends RangedAttack {

    public ReflectedRangedAttack(String originalAttackName) {
        this.name = "Reflected " + originalAttackName;
    }
}
