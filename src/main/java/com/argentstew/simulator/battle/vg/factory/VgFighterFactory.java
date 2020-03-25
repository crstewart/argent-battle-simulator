package com.argentstew.simulator.battle.vg.factory;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.vg.bowser.Bowser;
import com.argentstew.simulator.battle.vg.charizard.Charizard;
import com.argentstew.simulator.battle.vg.diddykong.DiddyKong;
import com.argentstew.simulator.battle.vg.donkeykong.DonkeyKong;
import com.argentstew.simulator.battle.vg.fox.Fox;
import com.argentstew.simulator.battle.vg.ganondorf.Ganondorf;
import com.argentstew.simulator.battle.vg.kingdedede.KingDedede;
import com.argentstew.simulator.battle.vg.kirby.Kirby;
import com.argentstew.simulator.battle.vg.link.Link;
import com.argentstew.simulator.battle.vg.luigi.Luigi;
import com.argentstew.simulator.battle.vg.mario.Mario;
import com.argentstew.simulator.battle.vg.mewtwo.Mewtwo;
import com.argentstew.simulator.battle.vg.peach.Peach;
import com.argentstew.simulator.battle.vg.pikachu.Pikachu;
import com.argentstew.simulator.battle.vg.ridley.Ridley;
import com.argentstew.simulator.battle.vg.samus.Samus;
import com.argentstew.simulator.battle.vg.wario.Wario;
import com.argentstew.simulator.battle.vg.yoshi.Yoshi;
import com.argentstew.simulator.battle.vg.zelda.Zelda;

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
            default:
                throw new IllegalStateException("Fighter not found!");
        }
    }
}
