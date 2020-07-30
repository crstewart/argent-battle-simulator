package com.argentstew.simulator.battle.vg.crash;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.BarrierChange;
import com.argentstew.simulator.battle.vg.magus.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.crash
 * 3/31/2020
 *
 * @author argen
 */
public class CrashBandicoot {

    public static final String NAME = "Crash Bandicoot";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.MYSTIC, 0.75);
        defenses.set(AttackSubType.EARTH, 0.75);

        FighterStats stats = FighterStats.builder().strength(7.5).toughness(6).dexterity(4.5).aim(5)
                .agility(6).speed(5.5).intellect(2).willpower(5).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A brawler with high strength and agility but limited options.")
                .entryQuotes(Arrays.asList("Crash: 'Uh-oh!", "Crash: 'Whoa!'"))
                .victoryQuotes(Arrays.asList("Crash: 'Yeee-HAW!'", "Crash: 'Pancakes!'"))
                .classifications(Collections.singletonList(FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new CycloneSpin()).addAction(new BodySlam()).addAction(new FruitBazooka())
                .addAction(new AkuAkusProtection())
                .addAction(new DeathTornadoSpin())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }

}
