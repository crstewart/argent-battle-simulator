package com.argentstew.simulator.battle.strategy;

import com.argentstew.simulator.battle.action.Action;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/20/2019
 *
 * @author Craig
 */
public class BasicStrategy implements Strategy {

    private static final double MIN_WEIGHT = 0.01;

    private Map<String, Double> weights;

    public BasicStrategy() {
        this(new HashMap<>());
    }

    public BasicStrategy(Collection<Action> actions) {
        this.weights = new HashMap<>();
        for (Action action : actions) {
            weights.put(action.getName(), 1.0);
        }
    }

    public BasicStrategy(Map<Action, Double> weights) {
        this.weights = weights.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().getName(), Map.Entry::getValue));
    }

    @Override
    public Double addAction(Action action, double weight) {
        return weights.put(action.getName(), weight);
    }

    @Override
    public void setWeight(Action action, double weight) {
        if (weight < MIN_WEIGHT) {
            throw new IllegalStateException("Strategy weight cannot be less than 0.01");
        }
        weights.put(action.getName(), weight);
    }

    @Override
    public void adjustWeight(Action action, double adjustment) {
        if (!weights.containsKey(action.getName())) {
            return;
        }

        double initialWeight = weights.get(action.getName());
        double adjustedWeight = initialWeight + adjustment;
        if (adjustedWeight < MIN_WEIGHT) {
            adjustedWeight = MIN_WEIGHT;
        }
        weights.put(action.getName(), adjustedWeight);
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
            totalWeight += weights.get(action.getName());
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
