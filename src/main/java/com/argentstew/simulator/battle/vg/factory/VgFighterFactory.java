package com.argentstew.simulator.battle.vg.factory;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.vg.bowser.Bowser;
import com.argentstew.simulator.battle.vg.diddykong.DiddyKong;
import com.argentstew.simulator.battle.vg.donkeykong.DonkeyKong;
import com.argentstew.simulator.battle.vg.link.Link;
import com.argentstew.simulator.battle.vg.luigi.Luigi;
import com.argentstew.simulator.battle.vg.mario.Mario;
import com.argentstew.simulator.battle.vg.peach.Peach;
import com.argentstew.simulator.battle.vg.wario.Wario;
import com.argentstew.simulator.battle.vg.yoshi.Yoshi;

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
            default:
                throw new IllegalStateException("Fighter not found!");
        }
    }
}
