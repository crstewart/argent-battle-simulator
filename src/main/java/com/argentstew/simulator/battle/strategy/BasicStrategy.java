package com.argentstew.simulator.battle.strategy;

import com.argentstew.simulator.battle.action.Action;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/20/2019
 *
 * @author Craig
 */
public class BasicStrategy implements Strategy {

    private Map<Action, Double> weights;

    public BasicStrategy() {
        this(new HashMap<>());
    }

    public BasicStrategy(Collection<Action> actions) {
        this.weights = new HashMap<>();
        for (Action action : actions) {
            weights.put(action, 1.0);
        }
    }

    public BasicStrategy(Map<Action, Double> weights) {
        this.weights = weights;
    }

    @Override
    public Double addAction(Action action, double weight) {
        return weights.put(action, weight);
    }

    @Override
    public void setWeight(Action action, double weight) {
        weights.put(action, weight);
    }

    @Override
    public void adjustWeight(Action action, double adjustment) {
        double initialWeight = weights.get(action);
        weights.put(action, initialWeight + adjustment);
    }

    @Override
    public Action selectAction(List<Action> actions) {
        if (actions == null || actions.isEmpty()) {
            throw new IllegalStateException("Cannot choose no action!");
        }

        Map<Action, Double> relativeWeight = new HashMap<>();
        double totalWeight = 0;
        for (Action action: actions) {
            relativeWeight.put(action, totalWeight);
            totalWeight += weights.get(action);
        }

        double selector = Math.random() * totalWeight;
        Action selectedAction = null;
        for (Action action : actions) {
            if (selector > relativeWeight.get(action)) {
                selectedAction = action;
            } else {
                break;
            }
        }

        return selectedAction;
    }
}
