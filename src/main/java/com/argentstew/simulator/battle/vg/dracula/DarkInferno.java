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
public class DarkInferno extends MagicAttack {

    public DarkInferno() {
        super();
        this.name = "Dark Inferno";
        this.power = 90;
        this.variance = 8;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }
}
