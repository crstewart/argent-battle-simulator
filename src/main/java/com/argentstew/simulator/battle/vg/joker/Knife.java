package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class Knife extends MeleeAttack {

    public Knife() {
        super();
        this.name = "Knife";
        this.description = "Gains 40 SP";
        this.power = 45;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 40));
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return owner.getMaxMp() > owner.getMp() && StringUtils.isBlank(owner.getSelfStatus());
    }
}
