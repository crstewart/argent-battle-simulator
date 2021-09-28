package com.argentstew.simulator.battle.vg.wander;

import com.argentstew.simulator.battle.action.MoveAction;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.vg.wander
 * 8/23/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public class GatherLight extends MoveAction {

    public GatherLight() {
        this.setName("Gather Light");
        this.setDescription("Enables the move 'Strike Weakness'");
        this.setMessage("raises his blade and shines a light on his foe, revealing their weak spot!");
        this.setDirection(1);
    }

    @Override
    public double calculateSpeed() {
        return 0;
    }

    @Override
    public boolean isAllowed() {
        return !Wander.FOUND_WEAK_SPOT.equals(owner.getSelfStatus());
    }

    @Override
    public void move() {
        owner.setSelfStatus(Wander.FOUND_WEAK_SPOT);
    }
}
