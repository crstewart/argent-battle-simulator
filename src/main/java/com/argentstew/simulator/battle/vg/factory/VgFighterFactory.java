package com.argentstew.simulator.battle.vg.factory;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.vg.akuma.Akuma;
import com.argentstew.simulator.battle.vg.albertwesker.AlbertWesker;
import com.argentstew.simulator.battle.vg.arthas.Arthas;
import com.argentstew.simulator.battle.vg.arthur.Arthur;
import com.argentstew.simulator.battle.vg.bigdaddy.BigDaddy;
import com.argentstew.simulator.battle.vg.bowser.Bowser;
import com.argentstew.simulator.battle.vg.captfalcon.CaptainFalcon;
import com.argentstew.simulator.battle.vg.charizard.Charizard;
import com.argentstew.simulator.battle.vg.chunli.ChunLi;
import com.argentstew.simulator.battle.vg.cloud.Cloud;
import com.argentstew.simulator.battle.vg.cole.ColeMacgrath;
import com.argentstew.simulator.battle.vg.crash.CrashBandicoot;
import com.argentstew.simulator.battle.vg.crono.Crono;
import com.argentstew.simulator.battle.vg.dante.Dante;
import com.argentstew.simulator.battle.vg.diablo.Diablo;
import com.argentstew.simulator.battle.vg.diddykong.DiddyKong;
import com.argentstew.simulator.battle.vg.donkeykong.DonkeyKong;
import com.argentstew.simulator.battle.vg.dreggman.DrEggman;
import com.argentstew.simulator.battle.vg.drwily.DrWily;
import com.argentstew.simulator.battle.vg.erdrick.Erdrick;
import com.argentstew.simulator.battle.vg.ezio.Ezio;
import com.argentstew.simulator.battle.vg.fox.Fox;
import com.argentstew.simulator.battle.vg.ganondorf.Ganondorf;
import com.argentstew.simulator.battle.vg.gordonfreeman.GordonFreeman;
import com.argentstew.simulator.battle.vg.handsomejack.HandsomeJack;
import com.argentstew.simulator.battle.vg.heavy.Heavy;
import com.argentstew.simulator.battle.vg.heihachi.Heihachi;
import com.argentstew.simulator.battle.vg.inkling.Inkling;
import com.argentstew.simulator.battle.vg.jaina.Jaina;
import com.argentstew.simulator.battle.vg.jak.JakAndDaxter;
import com.argentstew.simulator.battle.vg.johnmarston.JohnMarston;
import com.argentstew.simulator.battle.vg.kefka.Kefka;
import com.argentstew.simulator.battle.vg.kingdedede.KingDedede;
import com.argentstew.simulator.battle.vg.kirby.Kirby;
import com.argentstew.simulator.battle.vg.kosmos.KOSMOS;
import com.argentstew.simulator.battle.vg.kratos.Kratos;
import com.argentstew.simulator.battle.vg.leonkennedy.LeonKennedy;
import com.argentstew.simulator.battle.vg.link.Link;
import com.argentstew.simulator.battle.vg.lloyd.LloydIrving;
import com.argentstew.simulator.battle.vg.luigi.Luigi;
import com.argentstew.simulator.battle.vg.magus.Magus;
import com.argentstew.simulator.battle.vg.marcusfenix.MarcusFenix;
import com.argentstew.simulator.battle.vg.mario.Mario;
import com.argentstew.simulator.battle.vg.marth.Marth;
import com.argentstew.simulator.battle.vg.masterchief.MasterChief;
import com.argentstew.simulator.battle.vg.megaman.MegaMan;
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
import com.argentstew.simulator.battle.vg.rayman.Rayman;
import com.argentstew.simulator.battle.vg.ridley.Ridley;
import com.argentstew.simulator.battle.vg.ryu.Ryu;
import com.argentstew.simulator.battle.vg.samus.Samus;
import com.argentstew.simulator.battle.vg.sephiroth.Sephiroth;
import com.argentstew.simulator.battle.vg.sigma.Sigma;
import com.argentstew.simulator.battle.vg.simon.SimonBelmont;
import com.argentstew.simulator.battle.vg.slycooper.SlyCooper;
import com.argentstew.simulator.battle.vg.snake.SolidSnake;
import com.argentstew.simulator.battle.vg.sonic.Sonic;
import com.argentstew.simulator.battle.vg.sora.Sora;
import com.argentstew.simulator.battle.vg.spyro.Spyro;
import com.argentstew.simulator.battle.vg.squall.Squall;
import com.argentstew.simulator.battle.vg.steve.Steve;
import com.argentstew.simulator.battle.vg.tails.Tails;
import com.argentstew.simulator.battle.vg.terry.TerryBogard;
import com.argentstew.simulator.battle.vg.thrall.Thrall;
import com.argentstew.simulator.battle.vg.tronbonne.TronBonne;
import com.argentstew.simulator.battle.vg.viewtifuljoe.ViewtifulJoe;
import com.argentstew.simulator.battle.vg.vyse.Vyse;
import com.argentstew.simulator.battle.vg.wario.Wario;
import com.argentstew.simulator.battle.vg.yoshi.Yoshi;
import com.argentstew.simulator.battle.vg.zelda.Zelda;
import com.argentstew.simulator.battle.vg.zero.Zero;

/**
 * com.argentstew.simulator.battle.vg.factory
 * 8/24/2019
 *
 * @author Craig
 */
public class VgFighterFactory {

    public Fighter getFighter(String name) {

        switch(name) {
            case Mario.NAME:
               return Mario.get();
            case Luigi.NAME:
                return Luigi.get();
            case Bowser.NAME:
                return Bowser.get();
            case Peach.NAME:
                return Peach.get();
            case DonkeyKong.NAME:
                return DonkeyKong.get();
            case DiddyKong.NAME:
                return DiddyKong.get();
            case Yoshi.NAME:
                return Yoshi.get();
            case Wario.NAME:
                return Wario.get();
            case Link.NAME:
                return Link.get();
            case Zelda.NAME:
                return Zelda.get();
            case Ganondorf.NAME:
                return Ganondorf.get();
            case Pikachu.NAME:
                return Pikachu.get();
            case Charizard.NAME:
                return Charizard.get();
            case Mewtwo.NAME:
                return Mewtwo.get();
            case Samus.NAME:
                return Samus.get();
            case Ridley.NAME:
                return Ridley.get();
            case Fox.NAME:
                return Fox.get();
            case Kirby.NAME:
                return Kirby.get();
            case KingDedede.NAME:
                return KingDedede.get();
            case Marth.NAME:
                return Marth.get();
            case Ness.NAME:
                return Ness.get();
            case CaptainFalcon.NAME:
                return CaptainFalcon.get();
            case Pit.NAME:
                return Pit.get();
            case Inkling.NAME:
                return Inkling.get();
            case MegaMan.NAME:
                return MegaMan.get();
            case DrWily.NAME:
                return DrWily.get();
            case Zero.NAME:
                return Zero.get();
            case Sigma.NAME:
                return Sigma.get();
            case TronBonne.NAME:
                return TronBonne.get();
            case Ryu.NAME:
                return Ryu.get();
            case ChunLi.NAME:
                return ChunLi.get();
            case Akuma.NAME:
                return Akuma.get();
            case LeonKennedy.NAME:
                return LeonKennedy.get();
            case AlbertWesker.NAME:
                return AlbertWesker.get();
            case ViewtifulJoe.NAME:
                return ViewtifulJoe.get();
            case Morrigan.NAME:
                return Morrigan.get();
            case Dante.NAME:
                return Dante.get();
            case Arthur.NAME:
                return Arthur.get();
            case Sonic.NAME:
                return Sonic.get();
            case Tails.NAME:
                return Tails.get();
            case DrEggman.NAME:
                return DrEggman.get();
            case Vyse.NAME:
                return Vyse.get();
            case Cloud.NAME:
                return Cloud.get();
            case Squall.NAME:
                return Squall.get();
            case Kefka.NAME:
                return Kefka.get();
            case Sephiroth.NAME:
                return Sephiroth.get();
            case Erdrick.NAME:
                return Erdrick.get();
            case Sora.NAME:
                return Sora.get();
            case Crono.NAME:
                return Crono.get();
            case Magus.NAME:
                return Magus.get();
            case CrashBandicoot.NAME:
                return CrashBandicoot.get();
            case Spyro.NAME:
                return Spyro.get();
            case JakAndDaxter.NAME:
                return JakAndDaxter.get();
            case RatchetAndClank.NAME:
                return RatchetAndClank.get();
            case NathanDrake.NAME:
                return NathanDrake.get();
            case Kratos.NAME:
                return Kratos.get();
            case ColeMacgrath.NAME:
                return ColeMacgrath.get();
            case SlyCooper.NAME:
                return SlyCooper.get();
            case SolidSnake.NAME:
                return SolidSnake.get();
            case SimonBelmont.NAME:
                return SimonBelmont.get();
            case Pacman.NAME:
                return Pacman.get();
            case Heihachi.NAME:
                return Heihachi.get();
            case KOSMOS.NAME:
                return KOSMOS.get();
            case LloydIrving.NAME:
                return LloydIrving.get();
            case GordonFreeman.NAME:
                return GordonFreeman.get();
            case Heavy.NAME:
                return Heavy.get();
            case MasterChief.NAME:
                return MasterChief.get();
            case MarcusFenix.NAME:
                return MarcusFenix.get();
            case Steve.NAME:
                return Steve.get();
            case NikoBellic.NAME:
                return NikoBellic.get();
            case JohnMarston.NAME:
                return JohnMarston.get();
            case BigDaddy.NAME:
                return BigDaddy.get();
            case TerryBogard.NAME:
                return TerryBogard.get();
            case HandsomeJack.NAME:
                return HandsomeJack.get();
            case Rayman.NAME:
                return Rayman.get();
            case Ezio.NAME:
                return Ezio.get();
            case PrinceOfPersia.NAME:
                return PrinceOfPersia.get();
            case Thrall.NAME:
                return Thrall.get();
            case Jaina.NAME:
                return Jaina.get();
            case Arthas.NAME:
                return Arthas.get();
            case Diablo.NAME:
                return Diablo.get();
            default:
                throw new IllegalStateException("Fighter not found!");
        }
    }
}
