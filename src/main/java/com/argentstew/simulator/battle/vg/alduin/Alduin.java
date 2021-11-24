package com.argentstew.simulator.battle.vg.alduin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.PowerScaling;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.alduin
 * 4/6/2020
 *
 * @author argen
 */
public class Alduin {

    public static final String NAME = "Alduin";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.FIRE, 0.75);
        defenses.set(AttackSubType.MYSTIC, 1.25);
        defenses.set(AttackSubType.AIR, 1.25);
        defenses.set(AttackSubType.GRAVITY, 1.6);

        FighterStats stats = FighterStats.builder().strength(7.5).toughness(8.5).dexterity(5).aim(4)
                .agility(5).speed(4).intellect(6.5).willpower(6).size(9).weight(8.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new PowerScaling()));
        return Fighter.builder().name(NAME).hp(200).maxHp(200).xStrikeMeter(0)
                .description("A tank that can break other powerful tanks by scaling his own power against their might.")
                .entryQuotes(Arrays.asList("Alduin: 'Those who do not bow will be devoured.'",
                        "Alduin: 'Fools! Treacherous slaves! Your hopes are all withered! I am your doom.'"))
                .victoryQuotes(Arrays.asList("Alduin: 'I am eternal! I cannot end!'",
                        "Alduin: 'I will devour your soul in Sovngarde!'"))
                .classifications(Arrays.asList(FighterClassification.DRAGON, FighterClassification.DIVINE))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new UnrelentingForce()).addAction(new FireBreath()).addAction(new FrostBreath())
                .addAction(new DragonTail())
                .addAction(new SovngardeSoulDevour())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
