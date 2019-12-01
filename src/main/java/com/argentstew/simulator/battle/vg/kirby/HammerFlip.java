package com.argentstew.simulator.battle.vg.kirby;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kirby
 * 8/24/2019
 *
 * @author Craig
 */
public class HammerFlip extends MeleeAttack {

    public HammerFlip() {
        super();
        this.name = "Hammer Flip";
        this.power = 120;
        this.variance = 8;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
