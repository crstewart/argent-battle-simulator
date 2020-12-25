package com.argentstew.simulator.battle.vg.ganondorf;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ganondorf
 * 8/27/2019
 *
 * @author Craig
 */
public class DarkLordGanon extends MeleeXStrike {

    public DarkLordGanon() {
        super();
        this.name = "Dark Lord Ganon";
        this.power = 280;
        this.variance = 12;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
