package com.argentstew.simulator.battle.vg.subzero;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.subzero
 * 8/24/2019
 *
 * @author Craig
 */
public class IceShatter extends MeleeXStrike {

    public IceShatter() {
        super();
        this.name = "Ice Shatter";
        this.description = "Has 50% critical hit chance";
        this.power = 180;
        this.variance = 9;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.ICE, AttackSubType.PUNCH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 0.5;
    }
}
