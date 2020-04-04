package com.argentstew.simulator.battle.vg.johnmarston;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.johnmarston
 * 8/24/2019
 *
 * @author Craig
 */
public class GatlingGun extends RangedXStrike {

    public GatlingGun() {
        super();
        this.name = "Gatling Gun";
        this.power = 200;
        this.variance = 20;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
