package com.argentstew.simulator.battle.vg.geralt;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.MonsterHunter;
import com.argentstew.simulator.battle.vg.draven.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.geralt
 * 4/11/2020
 *
 * @author argen
 */
public class GeraltOfRivia {

    public static final String NAME = "Geralt of Rivia";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);
        defenses.set(AttackSubType.SLASH, 0.9);
        defenses.set(AttackSubType.HACK, 0.9);
        defenses.set(AttackSubType.SMASH, 0.9);
        defenses.set(AttackSubType.PIERCE, 1.1);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.1);
        defenses.set(AttackSubType.TOXIC, 0.9);

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(7).dexterity(7.5).aim(7.5)
                .agility(6.5).speed(6).intellect(6).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new MonsterHunter()));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter who excels against monsters.")
                .entryQuotes(Arrays.asList("Geralt: 'I believe in the sword.'", "Geralt: 'Damn, you're ugly.'"))
                .victoryQuotes(Arrays.asList("Geralt: 'Time eats away at memories, distorts them. Sometimes we only remember the good...sometimes only the bad.'",
                        "Geralt: 'Evil is evil. Lesser, greater, middling...makes no difference.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new WitchersSword()).addAction(new AardSign()).addAction(new IgniSign())
                .addAction(new GrapeshotBomb()).addAction(new HeliotropSign())
                .addAction(new HuntOfTheWhiteWolf())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
