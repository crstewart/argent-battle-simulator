package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;

/**
 * com.argentstew.simulator.battle
 * 8/24/2019
 *
 * @author Craig
 */
public class TestApp {

    public static void main(String[] args) {
        int luigiWins = 0;
        int bowserWins = 0;
        int draws = 0;

        VgFighterFactory factory = new VgFighterFactory();
        for (int i = 0; i < 1000; i++) {
            Fighter luigi = factory.getFighter("Luigi");
            Fighter bowser = factory.getFighter("Bowser");

            DuelArena arena = new DuelArena();
            arena.setLeftFighter(luigi);
            arena.setRightFighter(bowser);

            Battle battle = new DuelBattle(luigi, bowser);
            battle.announce();
            battle.start();
            Fighter winner = battle.determineWinner();

            if (winner == null) {
                draws++;
            } else if ("Luigi".equals(winner.getName())) {
                luigiWins++;
            } else if ("Bowser".equals(winner.getName())) {
                bowserWins++;
            }
        }

        System.out.println(" *** Results:");
        System.out.println("       Luigi: " + luigiWins);
        System.out.println("       Bowser: " + bowserWins);
        System.out.println("       Draws: " + draws);
    }
}
