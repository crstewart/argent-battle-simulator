package com.argentstew.simulator.battle.vg.mbison;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mbison
 * 3/28/2020
 *
 * @author argen
 */
public class MBison {

    public static final String NAME = "M Bison";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.8);
        defenses.set(AttackSubType.KICK, 0.8);
        defenses.set(AttackSubType.HEADBUTT, 0.8);
        defenses.set(AttackSubType.SLAM, 0.8);
        defenses.set(AttackSubType.GRAPPLE, 0.8);
        defenses.set(AttackSubType.DARK, 0.7);
        defenses.set(AttackSubType.MYSTIC, 0.6);

        FighterStats stats = FighterStats.builder().strength(7).toughness(6).dexterity(4.5).aim(4)
                .agility(4).speed(4.5).intellect(6).willpower(5.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new NaturalAgility()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A brawler with powerful dark, mystic strikes.")
                .entryQuotes(Arrays.asList("M Bison: 'Now, face the mighty Bison!'",
                        "M Bison: 'Bow down before my Psycho Power!'"))
                .victoryQuotes(Arrays.asList("M Bison: 'Get lost, you can't compare with my powers!'",
                        "M Bison: 'Anyone who opposes me will be destroyed!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new PsychoCrusher()).addAction(new PsychoCannon()).addAction(new PsychoField())
                .addAction(new DoubleKneePress())
                .addAction(new PsychoPunisher())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
