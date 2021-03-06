package com.argentstew.simulator.battle.vg.luigi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.mario.*;
import com.argentstew.simulator.battle.vg.waluigi.Waluigi;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/26/2019
 *
 * @author Craig
 */
public class Luigi {

    public static final String NAME = "Luigi";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PIERCE, 1.25);
        defenses.set(AttackSubType.FIRE, 1.25);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(4.5).dexterity(6.5).aim(6.5)
                .agility(5.5).speed(5).intellect(5).willpower(5.5).size(4).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Rival(Waluigi.NAME, 1.3)));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter whose punch attack can land surprising critical hits.")
                .entryQuotes(Arrays.asList("Luigi: 'It's-a go time!'",
                        "Luigi: 'This looks like a job for Luigi!'"))
                .victoryQuotes(Arrays.asList("Luigi: 'Luigi win! Luigi number one! Wow.'",
                        "Luigi: 'Yeah! Luigi's the winner!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new GreenFireball()).addAction(new SuperPunch()).addAction(new HammerThrow())
                .addAction(new PoultergustPlunger()).addAction(new VanishCap())
                .addAction(new Poultergust())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
