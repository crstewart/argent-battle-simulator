package com.argentstew.simulator.battle.vg.sans;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sans
 * 11/10/2019
 *
 * @author Craig
 */
public class FinalAttack extends MagicXStrike {

    public FinalAttack() {
        super();
        this.name = "Final Attack";
        this.power = 200;
        this.variance = 24;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.PLASMA, AttackSubType.SLAM);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.setSelfStatus(Sans.TIRED_SELF_STATUS);
        return super.doAttack(defender);
    }
}
