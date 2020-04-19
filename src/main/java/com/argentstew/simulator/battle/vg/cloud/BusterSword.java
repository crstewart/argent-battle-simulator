package com.argentstew.simulator.battle.vg.cloud;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cloud
 * 8/24/2019
 *
 * @author Craig
 */
public class BusterSword extends MeleeAttack {

    public BusterSword() {
        super();
        this.name = "Buster Sword";
        this.description = "Gains 3 SP";
        this.power = 80;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        int mp = this.owner.getMp();
        this.owner.setMp(Math.min(mp + 3, this.owner.getMaxMp()));
        return super.doAttack(defender);
    }
}
