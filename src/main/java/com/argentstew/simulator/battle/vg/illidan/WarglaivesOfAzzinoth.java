package com.argentstew.simulator.battle.vg.illidan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.trait.impl.DemonHeart;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.illidan
 * 8/27/2019
 *
 * @author Craig
 */
public class WarglaivesOfAzzinoth extends MeleeAttack {

    public WarglaivesOfAzzinoth() {
        super();
        this.name = "Warglaives of Azzinoth";
        this.description = "Twice as fast while in demon form";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double calculateSpeed() {
        double speed = super.calculateSpeed();
        if (DemonHeart.DEMONIC_FORM_ENABLED_STATUS.equals(owner.getSelfStatus())) {
            speed *= 0.5;
        }

        return speed;
    }
}
