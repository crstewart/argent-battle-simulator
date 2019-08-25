package com.argentstew.simulator.battle.vg.factory;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Hazardous;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.bowser.*;
import com.argentstew.simulator.battle.vg.luigi.*;
import com.argentstew.simulator.battle.vg.mario.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.factory
 * 8/24/2019
 *
 * @author Craig
 */
public class VgFighterFactory {

    public Fighter getFighter(String name) {
        FighterDefenses defenses = new FighterDefenses();
        FighterStats stats = null;
        FighterTraits traits = null;

        switch(name) {
            case "Mario":
                defenses.set(AttackType.MAGIC, 0.9);
                defenses.set(AttackSubType.PIERCE, 1.2);
                defenses.set(AttackSubType.FIRE, 1.2);
                stats = FighterStats.builder().strength(6).toughness(5.5).dexterity(5.5).aim(6)
                        .agility(5).speed(5).intellect(5).willpower(5.5).size(4).weight(4.5).build();
                traits = new FighterTraits(Collections.singletonList(new Rival("Bowser", 1.1)));
                return Fighter.builder().name("Mario").hp(150).maxHp(150).xStrikeMeter(0)
                        .entryQuotes(Arrays.asList("Mario: 'Here we go!'", "Mario: 'It's-a me, Mario!'"))
                        .victoryQuotes(Arrays.asList("Mario: 'Thank you so much for playing my game!'",
                                "Mario: 'Yahoo! Mario's the winner!'"))
                        .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                        .defenses(defenses).stats(stats).traits(traits)
                        .strategy(new BalancedStrategy()).build()
                        .addAction(new PunchGlove()).addAction(new SuperHammer()).addAction(new Fireball())
                        .addAction(new Fludd()).addAction(new KoopaToss()).addAction(new MetalCap())
                        .addAction(new MarioFinale())
                        .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
            case "Luigi":
                defenses.set(AttackType.MAGIC, 0.9);
                defenses.set(AttackSubType.PIERCE, 1.2);
                defenses.set(AttackSubType.FIRE, 1.2);
                stats = FighterStats.builder().strength(5.5).toughness(4.5).dexterity(6).aim(6)
                        .agility(5.5).speed(5).intellect(5).willpower(5.5).size(4).weight(4.5).build();
                traits = new FighterTraits();
                return Fighter.builder().name("Luigi").hp(150).maxHp(150).xStrikeMeter(0)
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
            case "Bowser":
                defenses.set(AttackSubType.FIRE, 1.2);
                stats = FighterStats.builder().strength(8.5).toughness(10).dexterity(2).aim(2)
                        .agility(2).speed(2).intellect(3).willpower(6).size(8.5).weight(9).build();
                traits = new FighterTraits(Collections.singletonList(new Hazardous()));
                return Fighter.builder().name("Bowser").hp(200).maxHp(200).xStrikeMeter(0)
                        .entryQuotes(Arrays.asList("Bowser: 'I'll show you the power of the Koopa King!'",
                                "Bowser: 'Stomping fools is my business!'"))
                        .victoryQuotes(Arrays.asList("Bowser: 'I'm the biggest, baddest brute around, and don't you forget it.'",
                                "Bowser: 'What a total waste of time!'"))
                        .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.MONSTER))
                        .defenses(defenses).stats(stats).traits(traits)
                        .strategy(new OffensiveStrategy()).build()
                        .addAction(new KoopaClaw()).addAction(new FireBreath()).addAction(new BowserBomb())
                        .addAction(new FlyingSlam()).addAction(new WhirlingFortress())
                        .addAction(new GiantBowserPunch())
                        .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
            default:
                throw new IllegalStateException("Fighter not found!");
        }
    }
}
