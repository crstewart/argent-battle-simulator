package com.argentstew.simulator.battle.vg.sephiroth;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.vyse
 * 8/24/2019
 *
 * @author Craig
 */
public class SuperNova extends MagicXStrike {

    public SuperNova() {
        super();
        this.name = "Super Nova";
        this.description = "Always critical hits";
        this.power = 120;
        this.variance = 6;
        this.speed = 10;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 1;
    }
}
