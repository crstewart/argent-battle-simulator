package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterVariance;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.strategy.BasicStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle
 * 8/17/2019
 *
 * @author Craig
 */
public class Application {

    public static void main(String[] args) {

        Fighter fighter1 = Fighter.builder().name("Fighter 1").maxHp(100).hp(100)
                .strategy(new BasicStrategy())
                .build()
                .addAction(AttackAction.builder().name("Punch").power(5).variance(10).build())
                .addAction(AttackAction.builder().name("Kick").power(2).variance(16).build());
        Fighter fighter2 = Fighter.builder().name("Fighter 2").maxHp(100).hp(100)
                .strategy(new BasicStrategy())
                .build()
                .addAction(AttackAction.builder().name("Punch").power(5).variance(10).build())
                .addAction(AttackAction.builder().name("Kick").power(2).variance(16).build());

        Battle battle = new DuelBattle(fighter1, fighter2);
        battle.announce();
        battle.start();
        battle.determineWinner();
    }
}
