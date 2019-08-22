package com.argentstew.simulator.battle.strategy;

import com.argentstew.simulator.battle.action.Action;

import java.util.List;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/20/2019
 *
 * @author Craig
 */
public interface Strategy {

    Double addAction(Action action, double weight);
    void setWeight(Action action, double weight);
    void adjustWeight(Action action, double adjustment);
    Action selectAction(List<Action> actions);
}
