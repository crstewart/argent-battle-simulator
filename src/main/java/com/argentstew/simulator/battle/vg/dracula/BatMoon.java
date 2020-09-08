package com.argentstew.simulator.battle.vg.dracula;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.impl.BarrierChange;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dracula
 * 8/27/2019
 *
 * @author Craig
 */
public class BatMoon extends MagicAttack {

    public BatMoon() {
        super();
        this.name = "Bat Moon";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.WING);
        this.characteristics = Collections.emptyList();
        this.requiresMeleeRange = true;
    }
}
