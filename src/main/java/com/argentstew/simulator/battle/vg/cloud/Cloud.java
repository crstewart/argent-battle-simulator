package com.argentstew.simulator.battle.vg.cloud;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.sephiroth.Sephiroth;
import com.argentstew.simulator.battle.vg.vyse.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cloud
 * 3/29/2020
 *
 * @author argen
 */
public class Cloud {

    public static final String NAME = "Cloud Strife";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.NATURE, 0.8);
        defenses.set(AttackSubType.MYSTIC, 1.2);

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(5).dexterity(2.5).aim(6.5)
                .agility(5.5).speed(5.5).intellect(5).willpower(3).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Rival(Sephiroth.NAME, 1.2)));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).mp(0).maxMp(10).xStrikeMeter(0)
                .description("A brawler who can unleash stronger versions of his limit break attacks.")
                .entryQuotes(Arrays.asList("Cloud: 'Are sins ever forgiven...?'", "Cloud: 'Let's just...get this over with.'"))
                .victoryQuotes(Arrays.asList("Cloud: 'I pity you. You just don't get it at all. There's not a thing I don't cherish!'",
                        "Cloud: 'Nobody is perfect.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new BusterSword()).addAction(new BladeBeam()).addAction(new BladeBeamLimitBreak())
                .addAction(new CrossSlash()).addAction(new CrossSlashLimitBreak()).addAction(new Meteorain())
                .addAction(new MeteorainLimitBreak())
                .addAction(new Omnislash())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
