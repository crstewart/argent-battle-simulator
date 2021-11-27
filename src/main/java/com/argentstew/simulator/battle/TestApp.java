package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.BattleLogger;
import com.argentstew.simulator.battle.logger.NoopBattleLogger;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;
import com.argentstew.simulator.battle.vg.kerrigan.Kerrigan;

import java.util.ArrayList;
import java.util.List;

/**
 * com.argentstew.simulator.battle
 * 8/24/2019
 *
 * @author Craig
 */
public class TestApp {

    private static final String TEST_FIGHTER = Kerrigan.NAME;

    public static void main(String[] args) {

        List<String> results = new ArrayList<>();
        int overallWins = 0;
        int overallLosses = 0;
        int overallDraws = 0;

        VgFighterFactory factory = new VgFighterFactory();
        BattleLogger logger = new NoopBattleLogger();
        for (String fighter1Name : VgFighterFactory.FIGHTERS) {
            String fighter2Name = TEST_FIGHTER;
            if (fighter1Name.equals(fighter2Name)) {
                continue;
            }

            int fighter1Wins = 0;
            int fighter2Wins = 0;
            int draws = 0;

            System.out.println("Running battles for " + fighter1Name + " and " + fighter2Name + "...");
            for (int k = 0; k < 1000; k++) {
                Fighter fighter1 = factory.getFighter(fighter1Name);
                Fighter fighter2 = factory.getFighter(fighter2Name);

                DuelArena arena = new DuelArena();
                arena.setLeftFighter(fighter1);
                arena.setRightFighter(fighter2);

                Battle battle = new DuelBattle(fighter1, fighter2, logger);
                battle.announce();
                battle.start();
                Fighter winner = battle.determineWinner();

                if (winner == null) {
                    draws++;
                } else if (fighter1Name.equals(winner.getName())) {
                    fighter1Wins++;
                } else if (fighter2Name.equals(winner.getName())) {
                    fighter2Wins++;
                }
            }

            results.add(fighter1Name + " vs " + fighter2Name + ": " + fighter1Wins + " to " + fighter2Wins
                    + " (with " + draws + " draws)");
            overallWins += fighter2Wins;
            overallLosses += fighter1Wins;
            overallDraws += draws;
        }

        System.out.println(" *** Results:");
        for (String result : results) {
            System.out.println("      " + result);
        }
        System.out.println("  Wins: " + overallWins + ", Losses: " + overallLosses + ", Draws: " + overallDraws);
        System.out.println("  Win rate: " + ((overallWins + (overallDraws / 2.0)) / (overallWins + overallLosses + overallDraws)));
    }
}
