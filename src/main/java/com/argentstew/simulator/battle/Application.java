package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.arena.Arena;
import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
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

        Battle battle = new DuelBattle(mario, bowser);
        battle.announce();
        battle.start();
        battle.determineWinner();

//        Fighter fighter1 = Fighter.builder().name("Fighter 1").maxHp(100).hp(100)
//                .strategy(new BasicStrategy())
//                .build()
//                .addAction(AttackAction.builder().name("Punch").power(5).variance(10).build())
//                .addAction(AttackAction.builder().name("Kick").power(2).variance(16).build());
//        Fighter fighter2 = Fighter.builder().name("Fighter 2").maxHp(100).hp(100)
//                .strategy(new BasicStrategy())
//                .build()
//                .addAction(AttackAction.builder().name("Punch").power(5).variance(10).build())
//                .addAction(AttackAction.builder().name("Kick").power(2).variance(16).build());
//
//        Battle battle = new DuelBattle(fighter1, fighter2);
//        battle.announce();
//        battle.start();
//        battle.determineWinner();
    }
}
