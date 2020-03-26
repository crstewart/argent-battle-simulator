package com.argentstew.simulator.battle.vg.common;

import com.argentstew.simulator.battle.action.attack.MeleeAttack;

/**
 * com.argentstew.simulator.battle.vg.zelda
 * 8/27/2019
 *
 * @author Craig
 */
public class ReflectedMeleeAttack extends MeleeAttack {

    public ReflectedMeleeAttack(String originalAttackName) {
        this.name = "Reflected " + originalAttackName;
    }
}
