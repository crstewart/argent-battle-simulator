package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.BattleLogger;
import com.argentstew.simulator.battle.logger.NoopBattleLogger;
import com.argentstew.simulator.battle.logger.StandardBattleLogger;
import com.argentstew.simulator.battle.vg.agent47.Agent47;
import com.argentstew.simulator.battle.vg.akuma.Akuma;
import com.argentstew.simulator.battle.vg.albertwesker.AlbertWesker;
import com.argentstew.simulator.battle.vg.aloy.Aloy;
import com.argentstew.simulator.battle.vg.arthas.Arthas;
import com.argentstew.simulator.battle.vg.arthur.Arthur;
import com.argentstew.simulator.battle.vg.banjo.BanjoKazooie;
import com.argentstew.simulator.battle.vg.bigdaddy.BigDaddy;
import com.argentstew.simulator.battle.vg.bomberman.Bomberman;
import com.argentstew.simulator.battle.vg.bowser.Bowser;
import com.argentstew.simulator.battle.vg.bowserjr.BowserJr;
import com.argentstew.simulator.battle.vg.captfalcon.CaptainFalcon;
import com.argentstew.simulator.battle.vg.captprice.CaptainPrice;
import com.argentstew.simulator.battle.vg.charizard.Charizard;
import com.argentstew.simulator.battle.vg.chunli.ChunLi;
import com.argentstew.simulator.battle.vg.cloud.Cloud;
import com.argentstew.simulator.battle.vg.cole.ColeMacgrath;
import com.argentstew.simulator.battle.vg.commandershepard.CommanderShepard;
import com.argentstew.simulator.battle.vg.crash.CrashBandicoot;
import com.argentstew.simulator.battle.vg.crono.Crono;
import com.argentstew.simulator.battle.vg.cuphead.Cuphead;
import com.argentstew.simulator.battle.vg.dante.Dante;
import com.argentstew.simulator.battle.vg.deathwing.Deathwing;
import com.argentstew.simulator.battle.vg.diablo.Diablo;
import com.argentstew.simulator.battle.vg.diddykong.DiddyKong;
import com.argentstew.simulator.battle.vg.donkeykong.DonkeyKong;
import com.argentstew.simulator.battle.vg.doomslayer.DoomSlayer;
import com.argentstew.simulator.battle.vg.dovahkiin.Dovahkiin;
import com.argentstew.simulator.battle.vg.dracula.Dracula;
import com.argentstew.simulator.battle.vg.draven.Draven;
import com.argentstew.simulator.battle.vg.dreggman.DrEggman;
import com.argentstew.simulator.battle.vg.drwily.DrWily;
import com.argentstew.simulator.battle.vg.erdrick.Erdrick;
import com.argentstew.simulator.battle.vg.ezio.Ezio;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;
import com.argentstew.simulator.battle.vg.fox.Fox;
import com.argentstew.simulator.battle.vg.ganondorf.Ganondorf;
import com.argentstew.simulator.battle.vg.geralt.GeraltOfRivia;
import com.argentstew.simulator.battle.vg.gordonfreeman.GordonFreeman;
import com.argentstew.simulator.battle.vg.greninja.Greninja;
import com.argentstew.simulator.battle.vg.guybrush.GuybrushThreepwood;
import com.argentstew.simulator.battle.vg.handsomejack.HandsomeJack;
import com.argentstew.simulator.battle.vg.heavy.Heavy;
import com.argentstew.simulator.battle.vg.heihachi.Heihachi;
import com.argentstew.simulator.battle.vg.inkling.Inkling;
import com.argentstew.simulator.battle.vg.jaina.Jaina;
import com.argentstew.simulator.battle.vg.jak.JakAndDaxter;
import com.argentstew.simulator.battle.vg.johnmarston.JohnMarston;
import com.argentstew.simulator.battle.vg.joker.Joker;
import com.argentstew.simulator.battle.vg.kefka.Kefka;
import com.argentstew.simulator.battle.vg.kerrigan.Kerrigan;
import com.argentstew.simulator.battle.vg.kingdedede.KingDedede;
import com.argentstew.simulator.battle.vg.kingkrool.KingKRool;
import com.argentstew.simulator.battle.vg.kirby.Kirby;
import com.argentstew.simulator.battle.vg.kosmos.KOSMOS;
import com.argentstew.simulator.battle.vg.kratos.Kratos;
import com.argentstew.simulator.battle.vg.laracroft.LaraCroft;
import com.argentstew.simulator.battle.vg.leonkennedy.LeonKennedy;
import com.argentstew.simulator.battle.vg.link.Link;
import com.argentstew.simulator.battle.vg.lloyd.LloydIrving;
import com.argentstew.simulator.battle.vg.luigi.Luigi;
import com.argentstew.simulator.battle.vg.magus.Magus;
import com.argentstew.simulator.battle.vg.marcusfenix.MarcusFenix;
import com.argentstew.simulator.battle.vg.mario.Mario;
import com.argentstew.simulator.battle.vg.marth.Marth;
import com.argentstew.simulator.battle.vg.masterchief.MasterChief;
import com.argentstew.simulator.battle.vg.mbison.MBison;
import com.argentstew.simulator.battle.vg.megaman.MegaMan;
import com.argentstew.simulator.battle.vg.metaknight.Metaknight;
import com.argentstew.simulator.battle.vg.mewtwo.Mewtwo;
import com.argentstew.simulator.battle.vg.morrigan.Morrigan;
import com.argentstew.simulator.battle.vg.nathandrake.NathanDrake;
import com.argentstew.simulator.battle.vg.ness.Ness;
import com.argentstew.simulator.battle.vg.niko.NikoBellic;
import com.argentstew.simulator.battle.vg.pacman.Pacman;
import com.argentstew.simulator.battle.vg.peach.Peach;
import com.argentstew.simulator.battle.vg.pikachu.Pikachu;
import com.argentstew.simulator.battle.vg.pit.Pit;
import com.argentstew.simulator.battle.vg.princeofpersia.PrinceOfPersia;
import com.argentstew.simulator.battle.vg.ratchet.RatchetAndClank;
import com.argentstew.simulator.battle.vg.rathalos.Rathalos;
import com.argentstew.simulator.battle.vg.rayman.Rayman;
import com.argentstew.simulator.battle.vg.ridley.Ridley;
import com.argentstew.simulator.battle.vg.ryu.Ryu;
import com.argentstew.simulator.battle.vg.ryuhayabusa.RyuHayabusa;
import com.argentstew.simulator.battle.vg.samfisher.SamFisher;
import com.argentstew.simulator.battle.vg.samus.Samus;
import com.argentstew.simulator.battle.vg.sans.Sans;
import com.argentstew.simulator.battle.vg.scorpion.Scorpion;
import com.argentstew.simulator.battle.vg.sephiroth.Sephiroth;
import com.argentstew.simulator.battle.vg.shadow.Shadow;
import com.argentstew.simulator.battle.vg.shaokahn.ShaoKahn;
import com.argentstew.simulator.battle.vg.shovelknight.ShovelKnight;
import com.argentstew.simulator.battle.vg.sigma.Sigma;
import com.argentstew.simulator.battle.vg.simon.SimonBelmont;
import com.argentstew.simulator.battle.vg.slycooper.SlyCooper;
import com.argentstew.simulator.battle.vg.snake.SolidSnake;
import com.argentstew.simulator.battle.vg.sonic.Sonic;
import com.argentstew.simulator.battle.vg.sora.Sora;
import com.argentstew.simulator.battle.vg.spyro.Spyro;
import com.argentstew.simulator.battle.vg.squall.Squall;
import com.argentstew.simulator.battle.vg.steve.Steve;
import com.argentstew.simulator.battle.vg.subzero.SubZero;
import com.argentstew.simulator.battle.vg.sweettooth.SweetTooth;
import com.argentstew.simulator.battle.vg.sylvanas.Sylvanas;
import com.argentstew.simulator.battle.vg.tails.Tails;
import com.argentstew.simulator.battle.vg.teemo.Teemo;
import com.argentstew.simulator.battle.vg.terry.TerryBogard;
import com.argentstew.simulator.battle.vg.thrall.Thrall;
import com.argentstew.simulator.battle.vg.tracer.Tracer;
import com.argentstew.simulator.battle.vg.tronbonne.TronBonne;
import com.argentstew.simulator.battle.vg.viewtifuljoe.ViewtifulJoe;
import com.argentstew.simulator.battle.vg.vyse.Vyse;
import com.argentstew.simulator.battle.vg.waluigi.Waluigi;
import com.argentstew.simulator.battle.vg.wario.Wario;
import com.argentstew.simulator.battle.vg.widowmaker.Widowmaker;
import com.argentstew.simulator.battle.vg.wolf.Wolf;
import com.argentstew.simulator.battle.vg.yoshi.Yoshi;
import com.argentstew.simulator.battle.vg.zelda.Zelda;
import com.argentstew.simulator.battle.vg.zero.Zero;

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

    private static final String TEST_FIGHTER = Dracula.NAME;

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
