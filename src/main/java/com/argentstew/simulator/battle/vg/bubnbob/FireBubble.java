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
public class FireBubble extends RangedAttack {

    public FireBubble() {
        super();
        this.name = "Fire Bubble";
        this.power = 80;
        this.variance = 10;
        this.speed = 5.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
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
