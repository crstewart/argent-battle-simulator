package com.argentstew.simulator.battle.vg.tracer;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tracer
 * 8/27/2019
 *
 * @author Craig
 */
public class PulsePistols extends RangedAttack {

    public PulsePistols() {
        super();
        this.name = "Pulse Pistols";
        this.description = "Gains 35 SP";
        this.power = 75;
        this.variance = 20;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 35));
        return super.doAttack(defender);
    }
}
