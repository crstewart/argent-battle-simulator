package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.defense.Guard;
import org.apache.commons.lang3.StringUtils;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class RebelsGuard extends Guard {

    public RebelsGuard() {
        this.name = "Rebel's Guard";
        this.description = "Blocks all guardable attacks, reducing damage by 50% and gaining 50 SP";
        this.initiateMessage = "uses Rebel's Guard!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return true;
    }

    @Override
    public int applyDefense(int damage) {
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 50));
        return (int) Math.round(damage * 0.5);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return owner.getMaxMp() > owner.getMp() && StringUtils.isBlank(owner.getSelfStatus());
    }
}
