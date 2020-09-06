package com.argentstew.simulator.battle.vg.sylvanas;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.RangedStrategy;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.sylvanas
 * 4/5/2020
 *
 * @author argen
 */
public class Sylvanas {

    public static final String NAME = "Sylvanas Windrunner";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.7);
        defenses.set(AttackSubType.DARK, 0.75);
        defenses.set(AttackSubType.LIGHT, 1.25);
        defenses.set(AttackSubType.TOXIC, 0.8);

        FighterStats stats = FighterStats.builder().strength(4).toughness(7.5).dexterity(5.5).aim(8)
                .agility(6).speed(6.5).intellect(7).willpower(9).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).mp(0).maxMp(0).xStrikeMeter(0)
                .description("A dark weaponmaster whose attacks have additional stun chance.")
                .entryQuotes(Arrays.asList("Sylvanas: 'I have no time for games!'",
                        "Sylvanas: 'What are we if not slaves to this torment?'"))
                .victoryQuotes(Arrays.asList("Sylvanas: 'Victory for the Forsaken!'",
                        "Sylvanas: 'The Dark Lady watches over you.'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.UNDEAD))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new RangedStrategy()).build()
                .addAction(new BlackArrows()).addAction(new ShadowDagger()).addAction(new BansheeWail())
                .addAction(new LifeDrain())
                .addAction(new TouchOfDeath())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
