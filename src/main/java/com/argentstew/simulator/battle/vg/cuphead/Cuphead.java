package com.argentstew.simulator.battle.vg.cuphead;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Demonslayer;
import com.argentstew.simulator.battle.vg.captprice.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cuphead
 * 4/10/2020
 *
 * @author argen
 */
public class Cuphead {

    public static final String NAME = "Cuphead";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.75);
        defenses.set(AttackSubType.SMASH, 1.1);

        FighterStats stats = FighterStats.builder().strength(2).toughness(4).dexterity(6).aim(8.5)
                .agility(6).speed(4).intellect(6.5).willpower(8).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).mp(0).maxMp(10).xStrikeMeter(0)
                .description("A mage whose attacks have no elements and charge over time with successful hits and parries.")
                .entryQuotes(Arrays.asList("Announcer: 'Good day for a swell battle.'",
                        "Announcer: 'A brawl is surely brewing!'"))
                .victoryQuotes(Arrays.asList("Announcer: 'Knockout!'", "Announcer: 'Bravo!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new Peashooter()).addAction(new MegaBlast()).addAction(new Chaser())
                .addAction(new ChaosOrbit()).addAction(new Parry())
                .addAction(new EnergyBeam())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
