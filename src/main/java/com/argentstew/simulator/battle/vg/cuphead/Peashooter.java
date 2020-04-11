package com.argentstew.simulator.battle.vg.cuphead;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.impl.BarrierChange;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cuphead
 * 8/27/2019
 *
 * @author Craig
 */
public class Peashooter extends MagicAttack {

    public Peashooter() {
        super();
        this.name = "Peashooter";
        this.power = 40;
        this.variance = 10;
        this.speed = 1;
        this.subtypes = Collections.emptyList();
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 1));
        return super.doAttack(defender);
    }
}
