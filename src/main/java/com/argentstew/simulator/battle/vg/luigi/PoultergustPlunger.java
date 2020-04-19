package com.argentstew.simulator.battle.vg.luigi;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class PoultergustPlunger extends MeleeAttack {

    public PoultergustPlunger() {
        super();
        this.name = "Poultergust Plunger";
        this.description = "Damage reduced against heavy opponents";
        this.power = 55;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }

    @Override
    public double getBaseDamage() {
        return (power * 0.25) + ((owner.getStats().getStrength() - (owner.getStats().getWeight() * 0.5)));
    }
}
