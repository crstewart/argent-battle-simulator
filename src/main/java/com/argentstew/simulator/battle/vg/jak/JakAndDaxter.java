package com.argentstew.simulator.battle.vg.jak;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.spyro.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jak
 * 4/2/2020
 *
 * @author argen
 */
public class JakAndDaxter {

    public static final String NAME = "Jak & Daxter";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.ASSIST, 0.6);
        defenses.set(AttackSubType.DARK, 1.25);

        FighterStats stats = FighterStats.builder().strength(5).toughness(5.5).dexterity(6.5).aim(8)
                .agility(4.5).speed(4.5).intellect(4.5).willpower(5.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A weaponmaster duo who wields elemental gun attacks.")
                .entryQuotes(Arrays.asList("Jak: 'I'm through saving the world.'",
                        "Daxter: 'You'd better keep us alive, or I am never speaking to you again.'"))
                .victoryQuotes(Arrays.asList("Jak: 'A smart warrior never takes his opponent head on.'",
                        "Daxter: 'Hey! I'm the real hero here! You can call me... Orange Lightning, zazazing!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new ScatterGun()).addAction(new VulcanFury()).addAction(new Blaster())
                .addAction(new Lobber()).addAction(new SpinAttack())
                .addAction(new DarkGiantBlast())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
