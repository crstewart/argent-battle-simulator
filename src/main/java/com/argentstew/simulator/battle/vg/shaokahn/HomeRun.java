package com.argentstew.simulator.battle.vg.shaokahn;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.shaokahn
 * 8/24/2019
 *
 * @author Craig
 */
public class HomeRun extends MeleeXStrike {

    public HomeRun() {
        super();
        this.name = "Home Run";
        this.description = "Has 50% critical hit chance";
        this.power = 160;
        this.variance = 10;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.SMASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 0.5;
    }
}
