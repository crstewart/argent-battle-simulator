package com.argentstew.simulator.battle.vg.illidan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.trait.impl.DemonHeart;
import com.argentstew.simulator.battle.trait.impl.Demonslayer;
import com.argentstew.simulator.battle.trait.impl.StealthDetection;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.illidan
 * 4/5/2020
 *
 * @author argen
 */
public class Illidan {

    public static final String NAME = "Illidan Stormrage";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.7);
        defenses.set(AttackSubType.DARK, 0.7);
        defenses.set(AttackSubType.LIGHT, 1.3);

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(5).dexterity(6).aim(5)
                .agility(8).speed(8.5).intellect(6).willpower(6.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new Demonslayer(), new StealthDetection(), new DemonHeart()));
        return Fighter.builder().name(NAME).hp(130).maxHp(130).mp(0).maxMp(0).xStrikeMeter(0)
                .description("A speedy fighter and anti-mage who becomes more powerful upon changing to demon form.")
                .entryQuotes(Arrays.asList("Illidan: 'You are not prepared!'",
                        "Illidan: 'Feel the hatred of 10,000 years!'"))
                .victoryQuotes(Arrays.asList("Illidan: 'Who next shall taste my blades?'",
                        "Illidan: 'Vengeance is mine!'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.DEMONIC))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new IllidanStrategy(traits)).build()
                .addAction(new WarglaivesOfAzzinoth()).addAction(new FlameCrash()).addAction(new EyeBeam())
                .addAction(new DarkBarrage()).addAction(new ShadowBlast()).addAction(new Metamorphosis())
                .addAction(new TheHunt())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
