package com.argentstew.simulator.battle.vg.mario;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.bowser.Bowser;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/26/2019
 *
 * @author Craig
 */
public class Mario {

    public static final String NAME = "Mario";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PIERCE, 1.2);
        defenses.set(AttackSubType.FIRE, 1.2);

        FighterStats stats = FighterStats.builder().strength(6).toughness(6).dexterity(6.5).aim(6.5)
                .agility(5).speed(5).intellect(5).willpower(5.5).size(4).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Rival(Bowser.NAME, 1.3)));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter who can win any fight and deals extra damage to Bowser.")
                .entryQuotes(Arrays.asList("Mario: 'Here we go!'", "Mario: 'It's-a me, Mario!'"))
                .victoryQuotes(Arrays.asList("Mario: 'Thank you so much for playing my game!'",
                        "Mario: 'Yahoo! Mario's the winner!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Fireball()).addAction(new PunchGlove()).addAction(new SuperHammer())
                .addAction(new Fludd()).addAction(new KoopaToss()).addAction(new MetalCap())
                .addAction(new MarioFinale())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
