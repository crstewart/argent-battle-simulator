package com.argentstew.simulator.battle.vg.johnmarston;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.johnmarston
 * 8/27/2019
 *
 * @author Craig
 */
public class Lasso extends RangedAttack {

    public Lasso() {
        super();
        this.name = "Lasso";
        this.description = "Stuns the opponent and applies root for 2 turns";
        this.power = 15;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        return 1;
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        defender.setStatus(new StatusEffect(StatusType.ROOT, 2));
        return super.doAttack(defender);
    }
}
