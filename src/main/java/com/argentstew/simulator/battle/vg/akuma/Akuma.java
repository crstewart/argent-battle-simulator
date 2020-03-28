package com.argentstew.simulator.battle.vg.akuma;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.chunli.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.akuma
 * 3/28/2020
 *
 * @author argen
 */
public class Akuma {

    public static final String NAME = "Akuma";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.9);
        defenses.set(AttackSubType.KICK, 0.95);
        defenses.set(AttackSubType.HEADBUTT, 0.95);
        defenses.set(AttackSubType.SLAM, 0.95);
        defenses.set(AttackSubType.LIGHT, 1.1);
        defenses.set(AttackSubType.DARK, 0.9);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(3).dexterity(5).aim(4)
                .agility(7).speed(6).intellect(5).willpower(4).size(5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(130).maxHp(130).xStrikeMeter(0)
                .description("A speedy fighter with a powerful finishing move.")
                .entryQuotes(Arrays.asList("Akuma: 'I am Akuma! And I will teach you the meaning of pain!'",
                        "Akuma: 'You dare challenge me?!'"))
                .victoryQuotes(Arrays.asList("Akuma: 'No techniques are off-limits to me, but you hold yourself back.'",
                        "Akuma: 'This time, I will spare you. But the next time you face me, I will show no mercy!'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.DEMONIC))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new GouHadouken()).addAction(new GouShoryuken()).addAction(new TatsumakiZankukyaku())
                .addAction(new HyakkiShu())
                .addAction(new RagingDemon())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
