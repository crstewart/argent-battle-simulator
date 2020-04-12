package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.BattleLogger;
import com.argentstew.simulator.battle.logger.NoopBattleLogger;
import com.argentstew.simulator.battle.logger.StandardBattleLogger;
import com.argentstew.simulator.battle.vg.bigdaddy.BigDaddy;
import com.argentstew.simulator.battle.vg.cole.ColeMacgrath;
import com.argentstew.simulator.battle.vg.commandershepard.CommanderShepard;
import com.argentstew.simulator.battle.vg.diablo.Diablo;
import com.argentstew.simulator.battle.vg.dreggman.DrEggman;
import com.argentstew.simulator.battle.vg.drwily.DrWily;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;
import com.argentstew.simulator.battle.vg.ganondorf.Ganondorf;
import com.argentstew.simulator.battle.vg.handsomejack.HandsomeJack;
import com.argentstew.simulator.battle.vg.heavy.Heavy;
import com.argentstew.simulator.battle.vg.jaina.Jaina;
import com.argentstew.simulator.battle.vg.johnmarston.JohnMarston;
import com.argentstew.simulator.battle.vg.kefka.Kefka;
import com.argentstew.simulator.battle.vg.kerrigan.Kerrigan;
import com.argentstew.simulator.battle.vg.magus.Magus;
import com.argentstew.simulator.battle.vg.mario.Mario;
import com.argentstew.simulator.battle.vg.marth.Marth;
import com.argentstew.simulator.battle.vg.princeofpersia.PrinceOfPersia;
import com.argentstew.simulator.battle.vg.ridley.Ridley;
import com.argentstew.simulator.battle.vg.sans.Sans;
import com.argentstew.simulator.battle.vg.sonic.Sonic;
import com.argentstew.simulator.battle.vg.spyro.Spyro;
import com.argentstew.simulator.battle.vg.tracer.Tracer;
import com.argentstew.simulator.battle.vg.viewtifuljoe.ViewtifulJoe;

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
            "Lloyd Irving", "Gordon Freeman", "Heavy", "Master Chief", "Marcus Fenix", "Steve", "Niko Bellic",
            "John Marston", "Big Daddy", "Terry Bogard", "Handsome Jack", "Rayman", "Ezio Auditore",
            "Prince of Persia", "Thrall", "Jaina Proudmoore", "Arthas Menethil", "Diablo", "Sarah Kerrigan", "Tracer",
            "Sub-Zero", "Scorpion", "Bomberman", "Banjo & Kazooie", "Lara Croft", "Commander Shepard",
            "Ryu Hayabusa", "Dovahkiin", "Shovel Knight", "Sans", "Joker", "Doom Slayer", "Captain Price",
            "Cuphead", "Guybrush Threepwood", "Draven", "Geralt of Rivia");
    private static final String TEST_FIGHTER = ViewtifulJoe.NAME;

    public static void main(String[] args) {

        List<String> results = new ArrayList<>();
        int overallWins = 0;
        int overallLosses = 0;
        int overallDraws = 0;

        VgFighterFactory factory = new VgFighterFactory();
        BattleLogger logger = new NoopBattleLogger();
        for (String fighter1Name : FIGHTERS) {
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
    }
}
