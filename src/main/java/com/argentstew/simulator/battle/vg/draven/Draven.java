package com.argentstew.simulator.battle.vg.draven;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.guybrush.Cutlass;
import com.argentstew.simulator.battle.vg.guybrush.DestructomaticT47;
import com.argentstew.simulator.battle.vg.guybrush.Pistol;
import com.argentstew.simulator.battle.vg.guybrush.VoodooDoll;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.draven
 * 4/11/2020
 *
 * @author argen
 */
public class Draven {

    public static final String NAME = "Draven";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);

        FighterStats stats = FighterStats.builder().strength(6).toughness(4.5).dexterity(8).aim(7.5)
                .agility(5).speed(4.5).intellect(4.5).willpower(4).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(145).maxHp(145).mp(0).maxMp(10).xStrikeMeter(0)
                .description("A weaponmaster who has higher damage on some critical hits.")
                .entryQuotes(Arrays.asList("Draven: 'Welcome to the League of Draven.'",
                        "Draven: 'Who wants some Draven? Heheheh.'"))
                .victoryQuotes(Arrays.asList("Draven: 'Draven out!'", "Draven: 'Seems to be blood everywhere I go.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new ThrowingAxe()).addAction(new SpinningAxe()).addAction(new BloodRush())
                .addAction(new StandAside())
                .addAction(new WhirlingDeath())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
