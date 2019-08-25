package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * com.argentstew.simulator.battle
 * 8/24/2019
 *
 * @author Craig
 */
public class TestApp {

    private static final List<String> FIGHTERS = Arrays.asList("Mario", "Luigi", "Bowser");

    public static void main(String[] args) {

        List<String> results = new ArrayList<>();
        VgFighterFactory factory = new VgFighterFactory();
        for (int i = 0; i < FIGHTERS.size(); i++) {
            String fighter1Name = FIGHTERS.get(i);
            for (int j = i + 1; j < FIGHTERS.size(); j++) {
                String fighter2Name = FIGHTERS.get(j);

                int fighter1Wins = 0;
                int fighter2Wins = 0;
                int draws = 0;

                for (int k = 0; k < 1000; k++) {
                    Fighter fighter1 = factory.getFighter(fighter1Name);
                    Fighter fighter2 = factory.getFighter(fighter2Name);

                    DuelArena arena = new DuelArena();
                    arena.setLeftFighter(fighter1);
                    arena.setRightFighter(fighter2);

                    Battle battle = new DuelBattle(fighter1, fighter2);
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
            }
        }

        System.out.println(" *** Results:");
        for (String result : results) {
            System.out.println("      " + result);
        }
    }
}
