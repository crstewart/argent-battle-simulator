package com.argentstew.simulator.battle.action.move;

import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.status.StatusType;
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
public class Sleep extends MoveAction {

    public Sleep() {
        this.setName("Sleep");
        this.setMessage("is fast asleep!");
        this.setDirection(1);
    }

    @Override
    public boolean isDoable() {
        return owner.getStatus() != null && owner.getStatus().getType() == StatusType.SLEEP;
    }

    @Override
    public void move() {
        // no-op
    }

    @Override
    public double calculateSpeed() {
        return 0;
    }

    @Override
    public boolean isAllowed() {
        return false;
    }

    @Override
    public double getFailureAdjustment() {
        return 0;
    }
}
