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
public class GuardAction extends Action {

    private String name;
    private int speed;

    public void applyEffect(AttackAction attack) {

    }

    @Override
    public boolean isDoable() {
        return false;
    }
}
