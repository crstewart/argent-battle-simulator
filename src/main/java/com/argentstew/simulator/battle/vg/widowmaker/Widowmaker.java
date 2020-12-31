package com.argentstew.simulator.battle.vg.widowmaker;

import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.strategy.RangedStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.trait.impl.StealthDetection;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.widowmaker
 * 4/4/2020
 *
 * @author argen
 */
public class Widowmaker {

    public static final String NAME = "Widowmaker";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.3);

        FighterStats stats = FighterStats.builder().strength(4).toughness(5).dexterity(7).aim(10)
                .agility(6).speed(5).intellect(7).willpower(2).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new StealthDetection()));
        return Fighter.builder().name(NAME).hp(130).maxHp(130).mp(0).maxMp(0).xStrikeMeter(0)
                .description("A sniper weaponmaster with stealth detection and perfect aim.")
                .entryQuotes(Arrays.asList("Widowmaker: '\"Step into my parlor,\" said the spider to the fly.'",
                        "Widowmaker: 'À la vie, à la mort.'"))
                .victoryQuotes(Arrays.asList("Widowmaker: 'One shot, one kill.'",
                        "Widowmaker: 'A single death can change everything.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new RangedStrategy()).build()
                .addAction(new WidowsKissScoped()).addAction(new WidowsKissAutomatic()).addAction(new VenomMine())
                .addAction(new PerfectShot())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
