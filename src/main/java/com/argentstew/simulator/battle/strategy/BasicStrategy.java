package com.argentstew.simulator.battle.strategy;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.ShapeshiftAction;

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

    private final Map<String, Double> weights;

    public BasicStrategy() {
        this(new HashMap<>());
    }

    public BasicStrategy(Collection<Action> actions) {
        this.weights = new HashMap<>();
        for (Action action : actions) {
            weights.put(action.getBaseName(), 1.0);
        }
    }

    public BasicStrategy(Map<Action, Double> weights) {
        this.weights = weights.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().getBaseName(), Map.Entry::getValue));
    }

    @Override
    public Double addAction(Action action) {
        return addAction(action, 1.0);
    }

    protected Double addAction(Action action, double weight) {
        return weights.put(action.getBaseName(), weight);
    }

    @Override
    public void setWeight(Action action, double weight) {
        weights.put(action.getBaseName(), Math.max(weight, MIN_WEIGHT));
    }

    @Override
    public void adjustWeight(Action action, double adjustment) {
        if (!weights.containsKey(action.getBaseName())) {
            return;
        }

        double initialWeight = weights.get(action.getBaseName());
        double adjustedWeight = initialWeight + adjustment;
        if (adjustedWeight < MIN_WEIGHT) {
            adjustedWeight = MIN_WEIGHT;
        }

        weights.put(action.getBaseName(), adjustedWeight);
    }

    @Override
    public Action selectAction(List<Action> actions) {
        if (actions == null || actions.isEmpty()) {
            throw new IllegalStateException("Cannot choose no action!");
        }

        if (actions.size() == 1) {
            return actions.get(0);
        }

        Map<Action, Double> relativeWeight = new HashMap<>();
        double totalWeight = 0;
        for (Action action: actions) {
            relativeWeight.put(action, totalWeight);
            totalWeight += weights.get(action.getBaseName());
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

        if (selectedAction instanceof ShapeshiftAction) {
            ShapeshiftAction shapeshiftAction = (ShapeshiftAction) selectedAction;
            if (shapeshiftAction.hasClassToReplace()) {
                shapeshiftAction.replaceClass();
            }
        }

        return selectedAction;
    }
}
