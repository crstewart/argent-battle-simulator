package com.argentstew.simulator.battle.vg.bowser;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.FighterStats;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class FlyingSlam extends MeleeAttack {

    public FlyingSlam() {
        super();
        this.name = "Flying Slam";
        this.description = "Damage reduced against heavy opponents";
        this.power = 50;
        this.variance = 3;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.GRAPPLE, AttackSubType.SLAM);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }

    @Override
    public double getBaseDamage() {
        return (power * 0.25) + ((owner.getStat(FighterStats.STRENGTH) - (owner.getStat(FighterStats.WEIGHT) * 0.5)));
    }
}
