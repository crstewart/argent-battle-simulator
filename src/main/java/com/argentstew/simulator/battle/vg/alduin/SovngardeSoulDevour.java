package com.argentstew.simulator.battle.vg.alduin;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.alduin
 * 8/24/2019
 *
 * @author Craig
 */
public class SovngardeSoulDevour extends MeleeXStrike {

    public SovngardeSoulDevour() {
        super();
        this.name = "Sovngarde Soul Devour";
        this.description = "Has 50% critical hit chance";
        this.power = 200;
        this.variance = 10;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.MYSTIC, AttackSubType.GRAPPLE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 0.5;
    }
}
