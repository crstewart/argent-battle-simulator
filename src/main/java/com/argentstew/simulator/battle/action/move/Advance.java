package com.argentstew.simulator.battle.action.move;

import com.argentstew.simulator.battle.action.MoveAction;

/**
 * com.argentstew.simulator.battle.action.move
 * 8/23/2019
 *
 * @author Craig
 */
public class Advance extends MoveAction {

    public Advance() {
        this.setMessage("advances!");
        this.setDirection(1);
    }

    @Override
    public double getSpeed() {
        return 5.0 - (owner.getStats().getSpeed() / 2.0);
    }

    @Override
    public boolean isDoable() {
        return owner.getArena().canAdvance(owner);
    }

    @Override
    public void move() {
        owner.getArena().advance(owner);
    }
}
