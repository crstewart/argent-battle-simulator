package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.BattleLogger;
import com.argentstew.simulator.battle.logger.NoopBattleLogger;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * com.argentstew.simulator.battle
 * 8/24/2019
 *
 * @author Craig
 */
public class TestApp {

    private static final List<String> FIGHTERS = Arrays.asList("Mario", "Luigi", "Peach", "Bowser", "Donkey Kong",
            "Diddy Kong", "Yoshi", "Wario", "Link", "Zelda", "Ganondorf", "Pikachu", "Charizard", "Mewtwo",
            "Samus Aran", "Ridley", "Fox McCloud", "Kirby", "King Dedede", "Marth", "Ness", "Captain Falcon", "Pit",
            "Inkling", "Mega Man", "Dr. Wily", "Zero", "Sigma", "Tron Bonne", "Ryu", "Chun Li", "Akuma",
            "Leon Kennedy", "Albert Wesker", "Viewtiful Joe", "Morrigan Aensland", "Dante", "Arthur", "Sonic", "Tails",
            "Dr. Eggman", "Vyse", "Cloud Strife", "Squall Leonhart", "Kefka Palazzo", "Sephiroth", "Erdrick", "Sora",
            "Crono", "Magus", "Crash Bandicoot", "Spyro", "Jak & Daxter", "Ratchet & Clank", "Nathan Drake", "Kratos",
            "Cole MacGrath", "Sly Cooper", "Solid Snake", "Simon Belmont", "Pac-Man", "Heihachi Mishima", "KOS-MOS",
            "Lloyd Irving", "Gordon Freeman", "Heavy");

    public static void main(String[] args) {

        List<String> results = new ArrayList<>();
        VgFighterFactory factory = new VgFighterFactory();
        BattleLogger logger = new NoopBattleLogger();
        for (int i = 0; i < FIGHTERS.size() - 1; i++) {
            String fighter1Name = FIGHTERS.get(i);
//            for (int j = i + 1; j < FIGHTERS.size(); j++) {
//                String fighter2Name = FIGHTERS.get(j);
                String fighter2Name = FIGHTERS.get(FIGHTERS.size() - 1);

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
//            }
        }

        System.out.println(" *** Results:");
        for (String result : results) {
            System.out.println("      " + result);
        }
    }
}
