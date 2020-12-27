package com.argentstew.simulator.battle.vg.sweettooth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sweettooth
 * 4/5/2020
 *
 * @author argen
 */
public class SweetTooth {

    public static final String NAME = "Sweet Tooth";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.3);
        defenses.set(AttackSubType.FIRE, 0.8);
        defenses.set(AttackSubType.ICE, 0.7);

        FighterStats stats = FighterStats.builder().strength(6).toughness(7).dexterity(5).aim(6)
                .agility(4).speed(5).intellect(3).willpower(6).size(5).weight(5.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(160).maxHp(160).mp(0).maxMp(0).xStrikeMeter(0)
                .description("A brawler with a mix of different weapon attacks.")
                .entryQuotes(Arrays.asList("Sweet Tooth: 'Who wants a treat?'",
                        "Sweet Tooth: 'Blood, pain, grief coming your way!'"))
                .victoryQuotes(Arrays.asList("Sweet Tooth: 'Sweet Tooth is back, baby! Bigger than ever! Hahahahaha!'",
                        "Sweet Tooth: 'Now that I'm free, I'm going to be the greatest of all time!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new MacheteMassacre()).addAction(new ChainsawSlaughter()).addAction(new JawBreaker())
                .addAction(new Shotgun()).addAction(new MolotovCocktail())
                .addAction(new MechaTooth())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
