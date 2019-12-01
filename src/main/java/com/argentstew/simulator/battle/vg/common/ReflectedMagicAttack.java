package com.argentstew.simulator.battle.vg.common;

import com.argentstew.simulator.battle.action.attack.MagicAttack;

/**
 * com.argentstew.simulator.battle.vg.zelda
 * 8/27/2019
 *
 * @author Craig
 */
public class ReflectedMagicAttack extends MagicAttack {

    public ReflectedMagicAttack(String originalAttackName) {
        this.name = "Reflected " + originalAttackName;
    }
}
