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
        defenses.set(AttackType.MAGIC, 0.9);
        defenses.set(AttackSubType.PIERCE, 1.2);
        defenses.set(AttackSubType.FIRE, 1.2);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(4.5).dexterity(6).aim(6)
                .agility(5.5).speed(5).intellect(5).willpower(5.5).size(4).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .entryQuotes(Arrays.asList("Luigi: 'It's-a go time!'",
                        "Luigi: 'This looks like a job for Luigi!'"))
                .victoryQuotes(Arrays.asList("Luigi: 'Luigi win! Luigi number one! Wow.'",
                        "Luigi: 'Yeah! Luigi's the winner!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new SuperPunch()).addAction(new GreenFireball()).addAction(new HammerThrow())
                .addAction(new PoultergustPlunger()).addAction(new VanishCap())
                .addAction(new Poultergust())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
