package com.argentstew.simulator.battle.action;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.action
 * 8/21/2019
 *
 * @author Craig
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class DefenseAction extends Action {

    protected String name;
    protected String initiateMessage;
    protected String successMessage;
    protected String failureMessage;
    protected double speed;

    public boolean isSuccessful(AttackAction attack) {
        return true;
    }

    public abstract int applyDefense(int damage);

    public abstract AttackAction doCounterAttack(AttackAction attack, int damage);

    public double getSuccessAdjustment() {
        return owner.getStats().getIntellect() * 0.04;
    }

    @Override
    public double getFailureAdjustment() {
        return owner.getStats().getIntellect() * -0.03;
    }

}
