package com.argentstew.simulator.battle.vg.mario;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class KoopaToss extends MeleeAttack {

    public KoopaToss() {
        super();
        this.name = "Koopa Toss";
        this.description = "Damage reduced against heavy opponents";
        this.power = 60;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }

    @Override
    public double getBaseDamage() {
        return (power * 0.25) + ((owner.getStats().getStrength() - (owner.getStats().getWeight() * 0.5)));
    }
}
