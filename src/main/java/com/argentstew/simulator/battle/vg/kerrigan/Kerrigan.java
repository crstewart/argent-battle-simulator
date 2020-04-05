package com.argentstew.simulator.battle.vg.kerrigan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.diablo.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kerrigan
 * 4/4/2020
 *
 * @author argen
 */
public class Kerrigan {

    public static final String NAME = "Sarah Kerrigan";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.1);
        defenses.set(AttackSubType.TOXIC, 0.95);
        defenses.set(AttackSubType.NATURE, 0.95);

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(5).dexterity(6.5).aim(6)
                .agility(7.5).speed(5).intellect(5).willpower(2).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A futuristic all-around fighter who can spawn zerg to aid her in battle.")
                .entryQuotes(Arrays.asList("Kerrigan: 'Wait 'til they get a load of me!'", "Kerrigan: 'Here I come, ready or not.'"))
                .victoryQuotes(Arrays.asList("Kerrigan: 'The outcome is not in question. The Swarm will consume all.'",
                        "Kerrigan: 'Ha ha ha ha ha! I'm not done with you yet...'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.ALIEN))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new SpawnZerglings()).addAction(new SpawnBanelings()).addAction(new KineticBlast())
                .addAction(new LeapingStrike()).addAction(new Mend())
                .addAction(new SpawnLeviathan())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
