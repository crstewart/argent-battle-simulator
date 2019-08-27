package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.arena.Arena;
import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.StandardBattleLogger;
import com.argentstew.simulator.battle.strategy.BasicStrategy;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;

/**
 * com.argentstew.simulator.battle
 * 8/17/2019
 *
 * @author Craig
 */
public class Application {

    public static void main(String[] args) {

        VgFighterFactory factory = new VgFighterFactory();
        Fighter fighter1 = factory.getFighter("Donkey Kong");
        Fighter fighter2 = factory.getFighter("Diddy Kong");

        DuelArena arena = new DuelArena();
        arena.setLeftFighter(fighter1);
        arena.setRightFighter(fighter2);

        Battle battle = new DuelBattle(fighter1, fighter2, new StandardBattleLogger());
        battle.announce();
        battle.start();
        battle.determineWinner();
    }
}
