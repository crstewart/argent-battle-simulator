package com.argentstew.simulator.battle.vg.donkeykong;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.donkeykong
 * 8/26/2019
 *
 * @author Craig
 */
public class BarrelToss extends RangedAttack {

    private int uses;

    public BarrelToss() {
        super();
        this.name = "Barrel Toss";
        this.description = "Has 4 uses";
        this.power = 65;
        this.variance = 6;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
        this.uses = 4;
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        uses--;
        return super.doAttack(defender);
    }

    @Override
    public boolean isAllowed() {
        return uses > 0;
    }
}
