package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
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
public class Gun extends RangedAttack {

    private int ammo;

    public Gun() {
        super();
        this.name = "Gun";
        this.power = 80;
        this.variance = 8;
        this.speed = 1;
        this.ammo = 2;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 1;
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 40));
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0 && owner.getMaxMp() > owner.getMp() && StringUtils.isBlank(owner.getSelfStatus());
    }
}
