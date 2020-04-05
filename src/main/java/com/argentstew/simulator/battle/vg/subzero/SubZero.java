package com.argentstew.simulator.battle.vg.subzero;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.vg.tracer.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.subzero
 * 4/5/2020
 *
 * @author argen
 */
public class SubZero {

    public static final String NAME = "Sub-Zero";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.ICE, 0.95);
        defenses.set(AttackSubType.PUNCH, 0.95);
        defenses.set(AttackSubType.KICK, 0.95);
        defenses.set(AttackSubType.HEADBUTT, 0.95);
        defenses.set(AttackSubType.SLAM, 0.95);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(7).dexterity(6).aim(6.5)
                .agility(6).speed(5).intellect(5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(145).maxHp(145).mp(0).maxMp(100).xStrikeMeter(0)
                .description("An all-around fighter who can stun his opponents by freezing them.")
                .entryQuotes(Arrays.asList("Sub-Zero: 'This fight will be your last!'",
                        "Sub-Zero: 'You must go. There will be others.'"))
                .victoryQuotes(Arrays.asList("Sub-Zero: 'You call that \"kombat\"? Beg for your life.'",
                        "Sub-Zero: 'I am Sub-Zero. Grandmaster of the Lin Kuei.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new IceBlast()).addAction(new Slide()).addAction(new Uppercut())
                .addAction(new IceShower()).addAction(new FrostHammer()).addAction(new IcyCounter())
                .addAction(new IceShatter())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
