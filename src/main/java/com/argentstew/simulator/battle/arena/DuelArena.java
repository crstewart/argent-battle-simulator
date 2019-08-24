package com.argentstew.simulator.battle.arena;

import com.argentstew.simulator.battle.fighter.Fighter;

/**
 * com.argentstew.simulator.battle.arena
 * 8/23/2019
 *
 * @author Craig
 */
public class DuelArena implements Arena {

    private static final int MIN_POSITION = 1;
    private static final int MAX_POSITION = 5;

    private Fighter leftFighter;
    private Fighter rightFighter;

    private Position leftFighterPosition;
    private Position rightFighterPosition;

    public void setLeftFighter(Fighter fighter) {
        this.leftFighter = fighter;
        this.leftFighter.setArena(this);
        this.leftFighter.setDirection(1);
        this.leftFighterPosition = new Position(2, 0);
    }

    public void setRightFighter(Fighter fighter) {
        this.rightFighter = fighter;
        this.rightFighter.setArena(this);
        this.rightFighter.setDirection(-1);
        this.rightFighterPosition = new Position(4, 0);
    }

    @Override
    public boolean canAdvance(Fighter fighter) {
        if (fighter == null) {
            return false;
        } else if (fighter.equals(leftFighter)) {
            return (leftFighterPosition.getX() != MAX_POSITION - 1)
                    && (rightFighterPosition.getX() != leftFighterPosition.getX() + 1);
        }

        return (rightFighterPosition.getX() != MIN_POSITION + 1) &&
                (leftFighterPosition.getX() != rightFighterPosition.getX() - 1);
    }

    @Override
    public boolean canRetreat(Fighter fighter) {
        if (fighter == null) {
            return false;
        } else if (fighter.equals(leftFighter)) {
            return leftFighterPosition.getX() != MIN_POSITION;
        }

        return rightFighterPosition.getX() != MAX_POSITION;
    }

    @Override
    public void advance(Fighter fighter) {
        if (fighter != null) {
            if (fighter.equals(leftFighter)) {
                int x = leftFighterPosition.getX();
                leftFighterPosition.setX(x + 1);
            } else {
                int x = rightFighterPosition.getX();
                rightFighterPosition.setX(x - 1);
            }
        }
    }

    @Override
    public void retreat(Fighter fighter) {
        if (fighter != null) {
            if (fighter.equals(leftFighter)) {
                int x = leftFighterPosition.getX();
                leftFighterPosition.setX(x - 1);
            } else {
                int x = rightFighterPosition.getX();
                rightFighterPosition.setX(x + 1);
            }
        }
    }

    public Position getFighterPosition(Fighter fighter) {
        if (fighter == null) {
            return null;
        } else if (fighter.equals(leftFighter)) {
            return leftFighterPosition;
        }

        return rightFighterPosition;
    }
}
