package com.argentstew.simulator.battle.vg.tracer;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tracer
 * 8/27/2019
 *
 * @author Craig
 */
public class PulseBomb extends RangedAttack {

    public PulseBomb() {
        super();
        this.name = "Pulse Bomb";
        this.description = "Requires and uses max SP";
        this.power = 150;
        this.variance = 15;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.PLASMA, AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.setMp(0);
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return owner.getMp() == owner.getMaxMp();
    }
}
