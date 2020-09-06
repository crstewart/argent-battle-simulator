package com.argentstew.simulator.battle.vg.shadow;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shadow
 * 8/27/2019
 *
 * @author Craig
 */
public class ChaosSpear extends RangedAttack {

    public ChaosSpear() {
        super();
        this.name = "Chaos Spear";
        this.power = 65;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }
}
