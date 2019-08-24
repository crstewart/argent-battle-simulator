package com.argentstew.simulator.battle.arena;

import com.argentstew.simulator.battle.fighter.Fighter;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * com.argentstew.simulator.battle.arena
 * 8/23/2019
 *
 * @author Craig
 */
public interface Arena {

    double getDistanceBetweenFighters();
    boolean canAdvance(Fighter fighter);
    boolean canRetreat(Fighter fighter);
    void advance(Fighter fighter);
    void retreat(Fighter fighter);

    @Data
    @AllArgsConstructor
    class Position {
        private int x;
        private int y;
    }
}
