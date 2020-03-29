package com.argentstew.simulator.battle.vg.sora;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.DragonSlayer;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sora
 * 3/29/2020
 *
 * @author argen
 */
public class Sora {

    public static final String NAME = "Sora";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);
        defenses.set(AttackSubType.DARK, 0.9);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(6.5).dexterity(7).aim(6)
                .agility(5.5).speed(5).intellect(3).willpower(6.5).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(155).maxHp(155).mp(12).maxMp(12).xStrikeMeter(0)
                .description("An all-around fighter who can restore magic power through his guard ability.")
                .entryQuotes(Arrays.asList("Sora: No problem. Let's do it!'",
                        "Sora: Man. What kind of world is this, anyway?'"))
                .victoryQuotes(Arrays.asList("Sora: Sorry to run. But other worlds are calling.'",
                        "Sora: I dunno what that was about, but I'm glad it's over.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new KingdomKey()).addAction(new GuardBreak()).addAction(new Explosion())
                .addAction(new Fira()).addAction(new Counterguard()).addAction(new Cure())
                .addAction(new Ragnarok())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
