package com.argentstew.simulator.battle.vg.bigdaddy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.johnmarston.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bigdaddy
 * 4/4/2020
 *
 * @author argen
 */
public class BigDaddy {

    public static final String NAME = "Big Daddy";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.2);
        defenses.set(AttackSubType.FIRE, 1.1);
        defenses.set(AttackSubType.THUNDER, 1.1);
        defenses.set(AttackSubType.NATURE, 1.05);
        defenses.set(AttackSubType.HANDGUN, 0.8);
        defenses.set(AttackSubType.RIFLE, 0.9);
        defenses.set(AttackSubType.SHOTGUN, 0.85);
        defenses.set(AttackSubType.SMASH, 0.8);

        FighterStats stats = FighterStats.builder().strength(8).toughness(8).dexterity(1.5).aim(1.5)
                .agility(2.5).speed(2.5).intellect(1).willpower(6.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(180).maxHp(180).xStrikeMeter(0)
                .description("A tank with few attacks who mights mindlessly until the bitter end.")
                .entryQuotes(Arrays.asList("Big Daddy makes a daunting, low wailing sound as he enters.",
                        "Little Sister: 'Kill them, Mr. Bubbles! Kill them!'"))
                .victoryQuotes(Arrays.asList("Little Sister: 'I'm ready for dream time, Mr. B.'",
                        "Little Sister: 'It's alright. I know they'll be an angel soon.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new DrillSlam()).addAction(new DrillPunch()).addAction(new Charge())
                .addAction(new EnragedFrenzy())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
