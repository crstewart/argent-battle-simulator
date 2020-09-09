package com.argentstew.simulator.battle.balance;

import com.argentstew.simulator.battle.Battle;
import com.argentstew.simulator.battle.DuelBattle;
import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.BattleLogger;
import com.argentstew.simulator.battle.logger.NoopBattleLogger;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;

import java.io.FileWriter;
import java.util.*;

/**
 * com.argentstew.simulator.battle
 * 8/24/2019
 *
 * @author Craig
 */
public class BalanceTest {

    private static final List<String> FIGHTERS = VgFighterFactory.FIGHTERS;
    private static final int RUN_COUNT = 1000;

    public static void main(String[] args) throws Exception {
        FIGHTERS.sort(String::compareTo);

        Map<String, Double> results = new HashMap<>();
        VgFighterFactory factory = new VgFighterFactory();
        BattleLogger logger = new NoopBattleLogger();
        for (int i = 0; i < FIGHTERS.size() - 1; i++) {
            String fighter1Name = FIGHTERS.get(i);
            for (int j = i + 1; j < FIGHTERS.size(); j++) {
                String fighter2Name = FIGHTERS.get(j);

                double fighter1Wins = 0;
                double fighter2Wins = 0;
                double draws = 0;

                System.out.println("Running battles for " + fighter1Name + " and " + fighter2Name + "...");
                for (int k = 0; k < RUN_COUNT; k++) {
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

                results.put(fighter1Name + ":" + fighter2Name, (fighter1Wins + (draws / 2.0)) / (RUN_COUNT / 100.0));
                results.put(fighter2Name + ":" + fighter1Name, (fighter2Wins + (draws / 2.0)) / (RUN_COUNT / 100.0));
            }
        }

        System.out.println("Writing results...");

        FileWriter fileWriter = new FileWriter("balance.csv");
        for (String fighter : FIGHTERS) {
            fileWriter.write(",");
            fileWriter.write(fighter);
        }

        fileWriter.write("\n");

        for (String fighter : FIGHTERS) {
            fileWriter.write(fighter);
            for (String topRowFighter : FIGHTERS) {
                fileWriter.write(",");
                if (topRowFighter.equals(fighter)) {
                    fileWriter.write("50.00%");
                } else {
                    fileWriter.write(String.format("%1.2f%%", results.get(topRowFighter + ":" + fighter)));
                }
            }
            fileWriter.write("\n");
        }

        fileWriter.close();
    }
}
