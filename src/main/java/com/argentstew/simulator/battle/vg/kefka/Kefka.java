package com.argentstew.simulator.battle.vg.kefka;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.squall.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kefka
 * 3/29/2020
 *
 * @author argen
 */
public class Kefka {

    public static final String NAME = "Kefka Palazzo";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.7);
        defenses.set(AttackSubType.LIGHT, 0.75);
        defenses.set(AttackSubType.DARK, 1.25);
        defenses.set(AttackSubType.SLASH, 1.25);

        FighterStats stats = FighterStats.builder().strength(2).toughness(2).dexterity(6).aim(8)
                .agility(4).speed(4).intellect(7).willpower(7).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A crazed mage with even crazier techniques.")
                .entryQuotes(Arrays.asList("Kefka: 'Run! Run! Or you'll be well done!'",
                        "Kefka: 'Fire! Fire! Heh-heh-heh!'"))
                .victoryQuotes(Arrays.asList("Kefka: 'I'm a god! I'm all-powerful! Uwee-hee-hee...'",
                        "Kefka: 'Read my lips - mercy is for wimps! If they get in your way, kill them!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new HavocWing()).addAction(new Forsaken()).addAction(new Firaga())
                .addAction(new Blizzaga()).addAction(new Thundaga())
                .addAction(new LightOfJudgment())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
