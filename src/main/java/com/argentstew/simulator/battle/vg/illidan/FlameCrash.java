package com.argentstew.simulator.battle.vg.illidan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.trait.impl.DemonHeart;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.illidan
 * 8/27/2019
 *
 * @author Craig
 */
public class FlameCrash extends MeleeAttack {

    public FlameCrash() {
        super();
        this.name = "Flame Crash";
        this.description = "Additional 10 power while in demon form";
        this.power = 60;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.FIRE, AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getBaseDamage() {
        int adjustedPower = this.power;
        if (DemonHeart.DEMONIC_FORM_ENABLED_STATUS.equals(owner.getSelfStatus())) {
            adjustedPower += 10;
        }

        return (adjustedPower * 0.2) + (owner.getStats().getStrength() * 0.4);
    }
}
