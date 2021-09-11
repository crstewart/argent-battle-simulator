package com.argentstew.simulator.battle.vg.mallow;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.trait.impl.Psychopath;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mallow
 * 3/30/2020
 *
 * @author argen
 */
public class Mallow {

    public static final String NAME = "Mallow";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.7);
        defenses.set(AttackSubType.WATER, 0.8);
        defenses.set(AttackSubType.AIR, 0.8);
        defenses.set(AttackSubType.GRAVITY, 0.8);

        FighterStats stats = FighterStats.builder().strength(2).toughness(2).dexterity(6).aim(7)
                .agility(4).speed(5.5).intellect(6).willpower(5).size(3.5).weight(3).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Psychopath()));
        Fighter fighter = Fighter.builder().name(NAME).hp(130).maxHp(130).xStrikeMeter(0)
                .description("A mage who controls weather and can see his opponent's status.")
                .entryQuotes(Arrays.asList("Mallow: 'Hello. My name is Mallow.",
                        "Mallow: 'Give up now, while you still have a chance!'"))
                .victoryQuotes(Arrays.asList("Mallow: 'Ha! Hope you learned your lesson!'",
                        "Mallow: 'I'm all right now. Sorry...'"))
                .classifications(Collections.singletonList(FighterClassification.ALIEN))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new PsychopathStrategy()).build()
                .addAction(new Thunderbolt()).addAction(new Shocker()).addAction(new Snowy())
                .addAction(new Cymbals()).addAction(new HPRain())
                .addAction(new StarRain())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
        traits.getTrait(Psychopath.class).setUser(fighter);
        return fighter;
    }
}
