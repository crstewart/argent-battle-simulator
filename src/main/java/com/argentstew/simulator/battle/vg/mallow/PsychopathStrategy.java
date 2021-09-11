package com.argentstew.simulator.battle.vg.mallow;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.attack.XStrike;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.strategy.RangedStrategy;

import java.util.List;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/24/2019
 *
 * @author Craig
 */
public class PsychopathStrategy extends RangedStrategy {

    public PsychopathStrategy() {
        super();
    }

    private boolean isPrioritizingOffense = false;
    private boolean isPrioritizingDefense = false;

    public void normalize(List<Action> actions) {
        isPrioritizingOffense = false;
        isPrioritizingDefense = false;
        actions.stream().filter(action -> action instanceof AttackAction && !(action instanceof XStrike))
                .forEach(action -> this.setWeight(action, 1.5));
        actions.stream().filter(action -> action instanceof DefenseAction)
                .forEach(action -> this.setWeight(action, 1));
    }

    public void prioritizeDefense(List<Action> actions) {
        if (isPrioritizingOffense) {
            normalize(actions);
        }

        isPrioritizingOffense = false;
        isPrioritizingDefense = true;
        actions.stream().filter(action -> action instanceof DefenseAction)
                .forEach(action -> this.adjustWeight(action, 0.25));
        actions.stream().filter(action -> action instanceof AttackAction)
                .forEach(action -> this.adjustWeight(action, -0.25));
    }

    public void prioritizeOffense(List<Action> actions) {
        if (isPrioritizingDefense) {
            normalize(actions);
        }

        isPrioritizingOffense = true;
        isPrioritizingDefense = false;
        actions.stream().filter(action -> action instanceof AttackAction && !(action instanceof XStrike))
                .forEach(action -> this.adjustWeight(action, 0.25));
        actions.stream().filter(action -> action instanceof DefenseAction)
                .forEach(action -> this.adjustWeight(action, -0.25));
    }

    public void prioritizeHealing(List<Action> actions) {
        isPrioritizingOffense = false;
        isPrioritizingDefense = true;
        actions.stream().filter(action -> action instanceof Heal)
                .forEach(action -> this.setWeight(action, 2));
    }

    public void prioritizeXStrike(List<Action> actions) {
        isPrioritizingOffense = true;
        isPrioritizingDefense = false;
        actions.stream().filter(action -> action instanceof XStrike)
                .forEach(action -> this.adjustWeight(action, 5));
    }
}
