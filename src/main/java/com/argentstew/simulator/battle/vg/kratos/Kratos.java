package com.argentstew.simulator.battle.vg.kratos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.nathandrake.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kratos
 * 4/3/2020
 *
 * @author argen
 */
public class Kratos {

    public static final String NAME = "Kratos";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.FIRE, 0.95);
        defenses.set(AttackSubType.LIGHT, 1.1);
        defenses.set(AttackSubType.DARK, 1.1);

        FighterStats stats = FighterStats.builder().strength(7.5).toughness(8).dexterity(5).aim(4)
                .agility(6).speed(6).intellect(3).willpower(6.5).size(5.5).weight(5.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(155).maxHp(155).xStrikeMeter(0)
                .description("A vicious brawler with mild anti-mage properties.")
                .entryQuotes(Arrays.asList("Kratos: 'You will not see the end of this day.'",
                        "Kratos: 'My vengeance ends now.'"))
                .victoryQuotes(Arrays.asList("Kratos: 'By the gods, what have I become?'",
                        "Kratos: 'The Gods of Olympus have abandoned me. Now there is no hope!'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.DIVINE))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new BladesOfChaos()).addAction(new NemeanCestus()).addAction(new ApollosBow())
                .addAction(new ZeusFury()).addAction(new GoldenFleece())
                .addAction(new DivineReckoning())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
