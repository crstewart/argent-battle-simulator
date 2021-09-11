package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.trait.Trait;
import com.argentstew.simulator.battle.vg.mallow.PsychopathStrategy;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 11/10/2019
 *
 * @author Craig
 */
@Getter
@EqualsAndHashCode(exclude = {"user"})
public class Psychopath implements Trait {

    private final String name = "Psychopath";

    private Fighter user;
    private PsychopathStrategy strategy;

    public void setUser(Fighter user) {
        this.user = user;
        if (user.getStrategy() instanceof PsychopathStrategy) {
            this.strategy = (PsychopathStrategy) user.getStrategy();
        }
    }

    @Override
    public void setUpTurn() {
        if (user == null || strategy == null) {
            return;
        }

        Fighter opponent = user.getArena().getOpponent(user);
        if (opponent == null) {
            return;
        }

        int userHp = user.getHp();
        int opponentHp = opponent.getHp();
        int hpDifference = userHp - opponentHp;

        if (hpDifference < -30) {
            strategy.prioritizeDefense(user.getActions());
        } else if (hpDifference > 30) {
            strategy.prioritizeOffense(user.getActions());
        } else {
            strategy.normalize(user.getActions());
        }

        if (userHp < user.getMaxHp() / 2) {
            strategy.prioritizeHealing(user.getActions());
        }

        if (opponentHp < 50) {
            strategy.prioritizeXStrike(user.getActions());
        }
    }
}
