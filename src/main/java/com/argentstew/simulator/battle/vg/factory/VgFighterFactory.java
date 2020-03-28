package com.argentstew.simulator.battle.vg.factory;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.vg.akuma.Akuma;
import com.argentstew.simulator.battle.vg.albertwesker.AlbertWesker;
import com.argentstew.simulator.battle.vg.bowser.Bowser;
import com.argentstew.simulator.battle.vg.captfalcon.CaptainFalcon;
import com.argentstew.simulator.battle.vg.charizard.Charizard;
import com.argentstew.simulator.battle.vg.chunli.ChunLi;
import com.argentstew.simulator.battle.vg.diddykong.DiddyKong;
import com.argentstew.simulator.battle.vg.donkeykong.DonkeyKong;
import com.argentstew.simulator.battle.vg.drwily.DrWily;
import com.argentstew.simulator.battle.vg.fox.Fox;
import com.argentstew.simulator.battle.vg.ganondorf.Ganondorf;
import com.argentstew.simulator.battle.vg.inkling.Inkling;
import com.argentstew.simulator.battle.vg.kingdedede.KingDedede;
import com.argentstew.simulator.battle.vg.kirby.Kirby;
import com.argentstew.simulator.battle.vg.leonkennedy.LeonKennedy;
import com.argentstew.simulator.battle.vg.link.Link;
import com.argentstew.simulator.battle.vg.luigi.Luigi;
import com.argentstew.simulator.battle.vg.mario.Mario;
import com.argentstew.simulator.battle.vg.marth.Marth;
import com.argentstew.simulator.battle.vg.megaman.MegaMan;
import com.argentstew.simulator.battle.vg.mewtwo.Mewtwo;
import com.argentstew.simulator.battle.vg.ness.Ness;
import com.argentstew.simulator.battle.vg.peach.Peach;
import com.argentstew.simulator.battle.vg.pikachu.Pikachu;
import com.argentstew.simulator.battle.vg.pit.Pit;
import com.argentstew.simulator.battle.vg.ridley.Ridley;
import com.argentstew.simulator.battle.vg.ryu.Ryu;
import com.argentstew.simulator.battle.vg.samus.Samus;
import com.argentstew.simulator.battle.vg.sigma.Sigma;
import com.argentstew.simulator.battle.vg.tronbonne.TronBonne;
import com.argentstew.simulator.battle.vg.viewtifuljoe.ViewtifulJoe;
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
            default:
                throw new IllegalStateException("Fighter not found!");
        }
    }
}
