package com.argentstew.simulator.battle.vg.heihachi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.pacman.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.heihachi
 * 4/3/2020
 *
 * @author argen
 */
public class Heihachi {

    public static final String NAME = "Heihachi Mishima";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.95);
        defenses.set(AttackSubType.KICK, 0.95);
        defenses.set(AttackSubType.HEADBUTT, 0.95);
        defenses.set(AttackSubType.SLAM, 0.95);
        defenses.set(AttackSubType.GRAPPLE, 0.95);

        FighterStats stats = FighterStats.builder().strength(6).toughness(5).dexterity(5.5).aim(3.5)
                .agility(3).speed(4).intellect(5).willpower(5).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A brawler with powerful hand-to-hand techniques.")
                .entryQuotes(Arrays.asList("Heihachi: 'Show me what you've got.'",
                        "Heihachi: 'I'll be quick with your death!'"))
                .victoryQuotes(Arrays.asList("Heihachi: 'Come back when you're ready to fight.'",
                        "Heihachi: 'That felt good. Next!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new DemonUppercut()).addAction(new TsunamiKick()).addAction(new DemonScissors())
                .addAction(new Stonehead())
                .addAction(new LightningHammer())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
