package com.argentstew.simulator.battle.vg.kirby;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kirby
 * 8/24/2019
 *
 * @author Craig
 */
public class Inhale extends MeleeAttack {

    public Inhale() {
        super();
        this.name = "Inhale";
        this.description = "Copies an attack from the opponent on success";
        this.power = 75;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss()) {
            Action action = defender.getActions().get(0);
            Class<? extends Action> actionClass = action.getClass();
            try {
                action = actionClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

            this.owner.addAction(action);
            this.owner.getStrategy().addAction(action);
            this.owner.setSelfStatus("Copied");
        }

        return damageReport;
    }

    @Override
    public boolean isDoable() {
        return StringUtils.isBlank(this.owner.getSelfStatus());
    }
}
