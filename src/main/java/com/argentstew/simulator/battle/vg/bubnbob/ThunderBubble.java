package com.argentstew.simulator.battle.vg.bubnbob;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bubnbob
 * 8/27/2019
 *
 * @author Craig
 */
public class ThunderBubble extends RangedAttack {

    public ThunderBubble() {
        super();
        this.name = "Thunder Bubble";
        this.power = 100;
        this.variance = 12;
        this.speed = 6;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
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
