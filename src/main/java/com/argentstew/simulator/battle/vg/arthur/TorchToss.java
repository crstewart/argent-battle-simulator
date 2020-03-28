package com.argentstew.simulator.battle.vg.arthur;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.arthur
 * 8/24/2019
 *
 * @author Craig
 */
public class TorchToss extends MagicAttack {

    public TorchToss() {
        super();
        this.name = "Torch Toss";
        this.power = 65;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
        this.setRequiresMeleeRange(false);
    }
}
