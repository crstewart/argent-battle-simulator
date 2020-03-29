package com.argentstew.simulator.battle.vg.sora;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sora
 * 8/27/2019
 *
 * @author Craig
 */
public class Counterattack extends MeleeAttack {

    public Counterattack() {
        super();
        this.name = "Counterattack";
        this.power = 30;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 3));
        return super.doAttack(defender);
    }
}
