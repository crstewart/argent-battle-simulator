package com.argentstew.simulator.battle.vg.scorpion;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.ComboStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.scorpion
 * 4/5/2020
 *
 * @author argen
 */
public class Scorpion {

    public static final String NAME = "Scorpion";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.8);
        defenses.set(AttackSubType.KICK, 0.8);
        defenses.set(AttackSubType.HEADBUTT, 0.8);
        defenses.set(AttackSubType.SLAM, 0.8);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(6.5).dexterity(5.5).aim(5.5)
                .agility(5.5).speed(5).intellect(5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new ComboStrike()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).mp(0).maxMp(0).xStrikeMeter(0)
                .description("An all-around fighter who can pull opponents toward him.")
                .entryQuotes(Arrays.asList("Scorpion: 'Vengeance will be mine!'",
                        "Scorpion: 'Don't bother worrying about escape.'"))
                .victoryQuotes(Arrays.asList("Scorpion: 'I burn with pain! The Netherrealm beckons!'",
                        "Scorpion: 'You do not know fear.'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.UNDEAD))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Spear()).addAction(new HellfirePunch()).addAction(new Uppercut())
                .addAction(new LegTakedown()).addAction(new DemonSlam())
                .addAction(new Toasty())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
