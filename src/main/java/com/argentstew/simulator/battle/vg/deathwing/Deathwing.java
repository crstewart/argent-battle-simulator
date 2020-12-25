package com.argentstew.simulator.battle.vg.deathwing;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.deathwing
 * 4/1/2020
 *
 * @author argen
 */
public class Deathwing {

    public static final String NAME = "Deathwing";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.AIR, 1.3);
        defenses.set(AttackSubType.EARTH, 0.8);
        defenses.set(AttackSubType.MYSTIC, 1.4);
        defenses.set(AttackSubType.DARK, 1.2);
        defenses.set(AttackSubType.GRAVITY, 0.8);

        FighterStats stats = FighterStats.builder().strength(10).toughness(9).dexterity(3).aim(3)
                .agility(2).speed(2.5).intellect(2).willpower(9).size(10).weight(10).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(200).maxHp(200).xStrikeMeter(0)
                .description("A strong, tough tank with inaccurate but strong attacks.")
                .entryQuotes(Arrays.asList("Deathwing: 'I am power incarnate!'",
                        "Deathwing: 'I will not be denied!'"))
                .victoryQuotes(Arrays.asList("Deathwing: 'I was once known as Neltharion, but now I am become Deathwing, destroyer of worlds.'",
                        "Deathwing: 'You will learn to show respect!'"))
                .classifications(Collections.singletonList(FighterClassification.DRAGON))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new MoltenFlame()).addAction(new Incinerate()).addAction(new Onslaught())
                .addAction(new EarthShatter())
                .addAction(new Cataclysm())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
