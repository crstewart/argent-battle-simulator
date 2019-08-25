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
        Fighter mario = factory.getFighter("Mario");
        Fighter bowser = factory.getFighter("Bowser");

        DuelArena arena = new DuelArena();
        arena.setLeftFighter(mario);
        arena.setRightFighter(bowser);

        Battle battle = new DuelBattle(mario, bowser, new StandardBattleLogger());
        battle.announce();
        battle.start();
        battle.determineWinner();
    }
}
