package com.argentstew.simulator.battle.vg.agent47;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.agent47
 * 8/24/2019
 *
 * @author Craig
 */
public class PoisonSyringe extends MeleeAttack {

    private int uses;

    public PoisonSyringe() {
        super();
        this.name = "Poison Syringe";
        this.description = "Only usable once";
        this.power = 60;
        this.variance = 7;
        this.speed = 4;
        this.uses = 1;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        uses -= 1;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return uses > 0;
    }
}
