package com.argentstew.simulator.battle.vg.pacman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.simon.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pacman
 * 4/3/2020
 *
 * @author argen
 */
public class Pacman {

    public static final String NAME = "Pac-Man";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(4).dexterity(6.5).aim(6.5)
                .agility(5).speed(4.5).intellect(5).willpower(5.5).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(155).maxHp(155).xStrikeMeter(0)
                .description("An all-around fighter with a penchant for chomping down on his foes.")
                .entryQuotes(Arrays.asList("Pac-Man appears, prepared for a fight!",
                        "Pac-Man jumps into the battlefield."))
                .victoryQuotes(Arrays.asList("Pac-Man gives a wink and a thumbs up.",
                        "Pac-Man smiles and poses victoriously after his win."))
                .classifications(Collections.singletonList(FighterClassification.ALIEN))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new PacBite()).addAction(new PowerPellet()).addAction(new BonusFruit())
                .addAction(new Galaxian())
                .addAction(new SuperPacMan())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
