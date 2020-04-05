package com.argentstew.simulator.battle.vg.thrall;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.thrall
 * 8/27/2019
 *
 * @author Craig
 */
public class FeralSpirit extends MagicAttack {

    public FeralSpirit() {
        super();
        this.name = "Feral Spirit";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.MYSTIC);
        this.characteristics = Collections.emptyList();
    }
}
