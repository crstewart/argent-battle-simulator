package com.argentstew.simulator.battle.vg.captprice;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Demonslayer;
import com.argentstew.simulator.battle.vg.doomslayer.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.captprice
 * 4/10/2020
 *
 * @author argen
 */
public class CaptainPrice {

    public static final String NAME = "Captain Price";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(5).dexterity(5).aim(7)
                .agility(4).speed(4.5).intellect(5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Demonslayer()));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A modern all-around fighter with a set of guns at his disposal.")
                .entryQuotes(Arrays.asList("Capt. Price: 'Just another day at the office.'",
                        "Capt. Price: 'Ghost, come in! I'm under attack!'"))
                .victoryQuotes(Arrays.asList("Capt. Price: 'How quickly they forget that all it takes to change the course of history...is the will of a single man.'",
                        "Capt. Price: 'Your moves are miscalculated, and underestimating your enemies — your biggest mistake.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new M4A1()).addAction(new M1911()).addAction(new DesertEagle())
                .addAction(new CombatKnife())
                .addAction(new JuggernautSuit())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
