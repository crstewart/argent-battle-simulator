package com.argentstew.simulator.battle.fighter;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.XStrike;
import com.argentstew.simulator.battle.arena.Arena;
import com.argentstew.simulator.battle.strategy.Strategy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * com.argentstew.simulator.battle.fighter
 * 8/17/2019
 *
 * @author Craig
 */
@Data
@Builder
@AllArgsConstructor
public class Fighter {

    private String name;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int xStrikeMeter;

    private Arena arena;
    private int direction;

    private List<String> entryQuotes;
    private List<String> victoryQuotes;

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
            strategy.addAction(action);
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

    public void heal(int hp) {
        this.hp = Math.min(this.hp + hp, maxHp);
    }

    public void useMagic(int mpUsed) {
        this.mp = (mpUsed > this.mp) ? 0 : this.mp - mpUsed;
    }

    public void restoreMagic(int mp) {
        this.mp = Math.min(this.mp + mp, maxMp);
    }

    public void adjustXStrikeMeter(int adjustment) {
        this.xStrikeMeter += adjustment;
    }

    public String getEntryQuote() {
        int quoteIndex = (int) Math.floor(Math.random() * entryQuotes.size());
        return entryQuotes.get(quoteIndex);
    }

    public String getVictoryQuote() {
        int quoteIndex = (int) Math.floor(Math.random() * victoryQuotes.size());
        return victoryQuotes.get(quoteIndex);
    }

    @Override
    public String toString() {
        return name + " (" + hp + "/" + maxHp + ") [" + xStrikeMeter + "/"
                + XStrike.X_STRIKE_METER_READY + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighter fighter = (Fighter) o;
        return hp == fighter.hp &&
                maxHp == fighter.maxHp &&
                xStrikeMeter == fighter.xStrikeMeter &&
                direction == fighter.direction &&
                Objects.equals(name, fighter.name) &&
                Objects.equals(arena, fighter.arena) &&
                Objects.equals(entryQuotes, fighter.entryQuotes) &&
                Objects.equals(victoryQuotes, fighter.victoryQuotes) &&
                Objects.equals(classifications, fighter.classifications) &&
                Objects.equals(defenses, fighter.defenses) &&
                Objects.equals(stats, fighter.stats) &&
                Objects.equals(traits, fighter.traits) &&
                Objects.equals(strategy, fighter.strategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hp, maxHp, xStrikeMeter, arena, direction, entryQuotes, victoryQuotes, classifications, defenses, stats, traits, strategy);
    }
}
