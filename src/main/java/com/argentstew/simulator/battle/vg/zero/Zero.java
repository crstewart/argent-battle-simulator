package com.argentstew.simulator.battle.vg.zero;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.MaverickHunter;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.sigma.Sigma;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.zero
 * 3/27/2020
 *
 * @author argen
 */
public class Zero {

    public static final String NAME = "Zero";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);
        defenses.set(AttackSubType.FIRE, 1.2);
        defenses.set(AttackSubType.PLASMA, 0.8);
        defenses.set(AttackSubType.HANDGUN, 0.7);
        defenses.set(AttackSubType.RIFLE, 0.7);
        defenses.set(AttackSubType.SHOTGUN, 0.7);
        defenses.set(AttackSubType.EXPLOSIVE, 1.2);

        FighterStats stats = FighterStats.builder().strength(7).toughness(5).dexterity(9).aim(5)
                .agility(7).speed(5.5).intellect(4).willpower(3).size(5).weight(5.5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new MaverickHunter(), new Rival(Sigma.NAME, 1.3)));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A weaponmaster with experience fighting other mechs, especially Sigma.")
                .entryQuotes(Arrays.asList("Zero: 'Starting mission now!'",
                        "Zero: 'This will be over in a nanosecond.'"))
                .victoryQuotes(Arrays.asList("Zero: 'Did you really think I'd fall for those gimmicks? Give me a break.'",
                        "Zero: 'If X were here, he would have tried to talk things out first. Unfortunately for you, X isn't here.'"))
                .classifications(Collections.singletonList(FighterClassification.MECH))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new ZSaber()).addAction(new ZeroBlaster()).addAction(new Ryuenjin())
                .addAction(new Raijinken()).addAction(new GuardShell())
                .addAction(new GenmuZero())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
