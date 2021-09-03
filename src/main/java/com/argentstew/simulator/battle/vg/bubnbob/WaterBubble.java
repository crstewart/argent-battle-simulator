package com.argentstew.simulator.battle.vg.bubnbob;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bubnbob
 * 8/27/2019
 *
 * @author Craig
 */
public class WaterBubble extends MeleeAttack {

    public WaterBubble() {
        super();
        this.name = "Water Bubble";
        this.power = 75;
        this.variance = 12;
        this.speed = 4.5;
        this.subtypes = Arrays.asList(AttackSubType.WATER, AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        for (Action action : owner.getActions()) {
            if (action instanceof ChacknHeart) {
                ((ChacknHeart) action).addCharge();
            }
        }

        return super.doAttack(defender);
    }
}
