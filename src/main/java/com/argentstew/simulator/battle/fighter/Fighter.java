package com.argentstew.simulator.battle.fighter;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.arena.Arena;
import com.argentstew.simulator.battle.strategy.Strategy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * com.argentstew.simulator.battle.fighter
 * 8/17/2019
 *
 * @author Craig
 */
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Fighter {

    private String name;
    private int hp;
    private int maxHp;

    private Arena arena;
    private int direction;

    private List<Action> actions;
    private List<FighterClassification> classifications;

    private FighterDefenses defenses;
    private FighterStats stats;
    private FighterTraits traits;
    private Strategy strategy;

    public Fighter addAction(Action action) {
        if (actions == null) {
            actions = new ArrayList<>();
        }

        if (strategy != null) {
            strategy.addAction(action, 1.0);
        }

        action.setOwner(this);
        actions.add(action);
        return this;
    }

    public Fighter addActions(Iterable<Action> actions) {
        for (Action action : actions) {
            addAction(action);
        }

        return this;
    }

    public Action selectAction() {
        List<Action> doableActions = new ArrayList<>();
        for (Action action : actions) {
            if (action.isDoable()) {
                doableActions.add(action);
            }
        }

        return strategy.selectAction(doableActions);
    }

    public void takeDamage(int damage) {
        this.hp = (damage > this.hp) ? 0 : this.hp - damage;
    }

    @Override
    public String toString() {
        return name + " (" + hp + "/" + maxHp + ")";
    }
}
