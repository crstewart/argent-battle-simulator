package com.argentstew.simulator.battle.vg.agent47;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.agent47
 * 8/27/2019
 *
 * @author Craig
 */
public class M195Sniper extends RangedXStrike {

    public M195Sniper() {
        super();
        this.name = "M195 Sniper";
        this.description = "Has 50% critical hit chance";
        this.power = 175;
        this.variance = 8;
        this.speed = 7.5;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 0.5;
    }
}
