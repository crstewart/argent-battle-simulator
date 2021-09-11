package com.argentstew.simulator.battle.action.move;

import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.fighter.FighterStats;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.action.move
 * 8/23/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public class Retreat extends MoveAction {

    public Retreat() {
        this.setName("Retreat");
        this.setMessage("retreats!");
        this.setDirection(-1);
    }

    @Override
    public double calculateSpeed() {
        return 5.0 - (owner.getStat(FighterStats.SPEED) / 2.0);
    }

    @Override
    public boolean isAllowed() {
        return owner.getArena().canRetreat(owner);
    }

    @Override
    public void move() {
        owner.getArena().retreat(owner);
    }
}
