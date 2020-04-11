package com.argentstew.simulator.battle.vg.geralt;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.geralt
 * 9/7/2019
 *
 * @author Craig
 */
public class IgniSign extends MagicAttack {

    public IgniSign() {
        super();
        this.name = "Igni Sign";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
        this.setRequiresMeleeRange(true);
    }
}
