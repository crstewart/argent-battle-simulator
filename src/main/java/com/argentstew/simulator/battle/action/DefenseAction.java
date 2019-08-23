package com.argentstew.simulator.battle.action;

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
@Builder
@EqualsAndHashCode(callSuper = false)
public class DefenseAction extends Action {

    private String name;
    private String initiateMessage;
    private String successMessage;
    private String failureMessage;
    private int speed;

    public boolean isSuccessful(AttackAction attack) {
        return true;
    }

    public int applyDefense(int damage) {
        return 0;
    }

    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
