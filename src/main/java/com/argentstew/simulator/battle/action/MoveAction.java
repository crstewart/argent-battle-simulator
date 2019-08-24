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
@EqualsAndHashCode(callSuper = false)
public abstract class MoveAction extends Action {

    private String message;
    private int direction;

    public double getSpeed() {
        return 0;
    }

    @Override
    public boolean isDoable() {
        return true;
    }

    public abstract void move();
}
