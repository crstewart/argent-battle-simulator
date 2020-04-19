package com.argentstew.simulator.battle.vg.cuphead;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cuphead
 * 8/27/2019
 *
 * @author Craig
 */
public class Chaser extends MagicAttack {

    public Chaser() {
        super();
        this.name = "Chaser";
        this.description = "Gains 1 SP";
        this.power = 30;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.emptyList();
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 1));
        return super.doAttack(defender);
    }
}
