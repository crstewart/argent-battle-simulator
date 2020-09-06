package com.argentstew.simulator.battle.vg.bowserjr;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bowserjr
 * 8/24/2019
 *
 * @author Craig
 */
public class KoopaShellToss extends RangedAttack {

    public KoopaShellToss() {
        super();
        this.name = "Koopa Shell Toss";
        this.power = 50;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
