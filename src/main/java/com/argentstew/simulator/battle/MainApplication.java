package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.FileLogger;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;

/**
 * com.argentstew.simulator.battle
 * 4/11/2020
 *
 * @author argen
 */
public class MainApplication {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar abs.jar <fighter1-name> <fighter2-name>");
            System.exit(1);
        }

        try {
            VgFighterFactory factory = new VgFighterFactory();
            Fighter fighter1 = factory.getFighter(args[0]);
            Fighter fighter2 = factory.getFighter(args[1]);

            FileLogger fileLogger = new FileLogger();
            fileLogger.open(fighter1, fighter2);

            DuelArena arena = new DuelArena();
            arena.setLeftFighter(fighter1);
            arena.setRightFighter(fighter2);

            Battle battle = new DuelBattle(fighter1, fighter2, fileLogger);
            battle.announce();
            battle.start();
            battle.determineWinner();

            fileLogger.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(2);
        }
    }
}
