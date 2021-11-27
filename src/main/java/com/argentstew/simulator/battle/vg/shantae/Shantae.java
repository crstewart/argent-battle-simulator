package com.argentstew.simulator.battle.vg.shantae;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.shantae
 * 4/5/2020
 *
 * @author argen
 */
public class Shantae {

    public static final String NAME = "Shantae";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.GRAVITY, 0.95);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(5).dexterity(7).aim(5)
                .agility(6).speed(6).intellect(6.5).willpower(6).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).mp(40).maxMp(40).xStrikeMeter(0)
                .description("A defensive all-around fighter with a mixed bag of attacks and transformations.")
                .entryQuotes(Arrays.asList("Shantae: 'I can handle this!'", "Shantae: 'I had a feeling you'd show up!'"))
                .victoryQuotes(Arrays.asList("Shantae: 'Whew! Life as a half-genie is hard work!'",
                        "Shantae: '... Didn't you explode in a huge Stage Clear sequence?'"))
                .classifications(new ArrayList<FighterClassification>() {{ add(FighterClassification.HUMANOID); add(FighterClassification.DIVINE); }})
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new DefensiveStrategy()).build()
                .addAction(new HairWhip()).addAction(new ElephantStomp()).addAction(new SpiderVenom())
                .addAction(new Fireball())
                .addAction(new ReviveDance()).addAction(new PikeBall()).addAction(new Mirror())
                .addAction(new SuperPuffs())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
